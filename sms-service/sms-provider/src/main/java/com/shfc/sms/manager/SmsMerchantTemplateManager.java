package com.shfc.sms.manager;

import com.shfc.common.base.Logger;
import com.shfc.common.date.DateUtils;
import com.shfc.mybatis.pagination.Page;
import com.shfc.sms.dao.SmsMerchantSignMapper;
import com.shfc.sms.dao.SmsMerchantTemplateMapper;
import com.shfc.sms.domain.SmsMerchantSign;
import com.shfc.sms.domain.SmsMerchantTemplate;
import com.shfc.sms.dto.SmsMerchantTemplateDTO;
import com.shfc.sms.dto.TemplateResultDTO;
import com.shfc.sms.enums.AuditStatus;
import com.shfc.sms.enums.ChannelType;
import com.shfc.sms.yunpian.YunPianTemplateService;
import com.yunpian.sdk.constant.Code;
import com.yunpian.sdk.constant.YunpianConstant;
import com.yunpian.sdk.model.Result;
import com.yunpian.sdk.model.Template;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * Copyright: Copyright (c) 2016
 * Company:上海房产
 *
 * @author wky
 * @version V1.0
 * @create 2017-03-03 10:16
 **/
@Service
public class SmsMerchantTemplateManager {
    @Autowired
    private SmsMerchantSignMapper smsMerchantSignMapper;

    @Autowired
    private SmsMerchantTemplateMapper smsMerchantTemplateMapper;
    @Autowired(required = false)
    private YunPianTemplateService templateService;


    public SmsMerchantSign querySignBySignId(Long smsSignId) {

        return smsMerchantSignMapper.querySignBySignId(smsSignId);
    }

    /**
     * 根据主键ID查询
     * @param tplId 主键ID
     * @return
     * add by xiehb
     */
    public SmsMerchantTemplate selectByPrimaryKey(Long tplId) {

        return smsMerchantTemplateMapper.selectByPrimaryKey(tplId);
    }

    /**
     * 根据通道tplID查询
     * @param channelTplId
     * @return
     * add by xiehb
     */
    public SmsMerchantTemplate selectByChannelTplId(Long channelTplId){
        return smsMerchantTemplateMapper.selectByChannelTplId(channelTplId);
    }

    public List<TemplateResultDTO> queryTplByTplId(HashMap<String, Object> params) {
        return smsMerchantTemplateMapper.queryTplByTplId(params);
    }


    public Long addTpl(SmsMerchantTemplateDTO dto, TemplateResultDTO templateResultDTO) {
        SmsMerchantTemplate record = new SmsMerchantTemplate();
        record.setSmsSignId(dto.getSignId());
        record.setMerchantId(dto.getMerchantId());
        record.setChannelNo(dto.getChannelNo());
        record.setContent(templateResultDTO.getTplContent());
        record.setAuditStatus(AuditStatus.getValueByName(templateResultDTO.getCheckStatus()));
        record.setIsDelete(0);
        record.setChannel(ChannelType.YUNPIAN.getValue());
        record.setChannelTplId(dto.getChannelTplId());
        record.setCreater(dto.getMerchantId());
        try {
            smsMerchantTemplateMapper.insert(record);
            return record.getId();
        } catch ( Exception e ) {
            Logger.error(SmsMerchantTemplateManager.class, "addTpl数据库修改异常", e);
        }
        return null;
    }

    public void updateTpl(SmsMerchantTemplateDTO dto, TemplateResultDTO templateResultDTO) {
        SmsMerchantTemplate record = smsMerchantTemplateMapper.selectByPrimaryKey(dto.getTplId());
        record.setSmsSignId(dto.getSignId());
        record.setContent(templateResultDTO.getTplContent());
        record.setAuditStatus(AuditStatus.getValueByName(templateResultDTO.getCheckStatus()));
        record.setReason(templateResultDTO.getReason());
        record.setChannelTplId(dto.getChannelTplId());
        record.setModifier(dto.getMerchantId());
        try {
            smsMerchantTemplateMapper.updateByPrimaryKey(record);
        } catch ( Exception e ) {
            Logger.error(SmsMerchantTemplateManager.class, "updateTpl数据库修改异常", e);
        }
    }

    public void delTpl(SmsMerchantTemplateDTO dto, TemplateResultDTO templateResultDTO) {
        SmsMerchantTemplate record = smsMerchantTemplateMapper.selectByPrimaryKey(dto.getTplId());
        record.setChannelTplId(templateResultDTO.getTplId());
        record.setIsDelete(1);
        record.setModifier(dto.getMerchantId());
        try {
            smsMerchantTemplateMapper.updateByPrimaryKey(record);
        } catch ( Exception e ) {
            Logger.error(SmsMerchantTemplateManager.class, "delTpl数据库修改异常", e);

        }
    }

    /**
     * @param
     * @return List<Plot>
     * @throws
     * @Description: 查询模板
     * @Title queryTpl
     * @Author wuky
     * @Date 2017/03/08 17:41
     */
    public Page<SmsMerchantTemplate> queryTpl(Page<SmsMerchantTemplate> page) {
        smsMerchantTemplateMapper.queryTpl(page);
        return page;
    }


    /**
     * @param
     * @return void
     * @throws
     * @Description: 同步模板审核状态
     * @Title syncTpl
     * @Author wuky
     * @Date 2017/03/08 17:25
     */
    public void syncTpl() {
        Logger.info(SmsMerchantTemplateManager.class, DateUtils.getCurrentTime() + "开启模板审核状态查询服务");
        Page<SmsMerchantTemplate> page = new Page<SmsMerchantTemplate>(1, 50);
        page = queryTpl(page);
        Integer totalPage = page.getTotalPage();

        for (Integer start = 1; start <= totalPage; start++) {
            Page<SmsMerchantTemplate> pageResult = new Page<SmsMerchantTemplate>(start, 50);
            Logger.info(SmsMerchantTemplateManager.class, DateUtils.getCurrentTime() + "定时更新模板审核状态第: " + start + " 页");
            pageResult = queryTpl(pageResult);
            if (pageResult.getData() != null) {
                for (SmsMerchantTemplate smsMerchantTemplate : pageResult.getData()) {
                    Map<String, String> param = new HashMap<String, String>();
                    param.put(YunpianConstant.TPL_ID, smsMerchantTemplate.getChannelTplId().toString());
                    Result<List<Template>> result = templateService.getTemplate(smsMerchantTemplate.getMerchantId(),smsMerchantTemplate.getChannelNo(), param);
                    Logger.info(SmsMerchantTemplateManager.class, "获取模板信息====" + result.toString());
                    if (result.getCode() == Code.OK) {
                        for (Template tpl : result.getData()) {
                            Integer status = AuditStatus.getValueByName(tpl.getCheck_status());
                            SmsMerchantTemplate record = smsMerchantTemplateMapper.selectByChannelTplId(tpl.getTpl_id());
                            record.setAuditStatus(status);
                            record.setReason(tpl.getReason());
                            record.setChannelTplId(tpl.getTpl_id());
                            try {
                                smsMerchantTemplateMapper.updateByPrimaryKey(record);
                            } catch ( Exception e ) {
                                Logger.error(SmsMerchantTemplateManager.class, "更新模板审核状态异常", e);

                            }
                        }

                    }
                }
            }
        }
    }
}

