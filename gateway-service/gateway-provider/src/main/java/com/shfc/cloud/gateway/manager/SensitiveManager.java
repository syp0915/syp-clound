package com.shfc.cloud.gateway.manager;

import com.shfc.cloud.gateway.dao.SensitiveWordMapper;
import com.shfc.cloud.gateway.domain.SensitiveWord;
import com.shfc.cloud.gateway.dto.SensitiveDTO;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 类注释
 *
 * @author zhangjh
 * @version 1.0.0 createTime: 2017/3/23 14:18
 * @since 1.0
 */
@Service
public class SensitiveManager {
    @Resource
    private SensitiveWordMapper sensitveWordMapper;

    public Boolean insert(SensitiveDTO sensitiveDTO) {
        SensitiveWord sensitveWord=new SensitiveWord();
        BeanUtils.copyProperties(sensitiveDTO,sensitveWord);
        return sensitveWordMapper.insert(sensitveWord)==1;
    }

    public List<SensitiveWord> select(String sensitiveWord) {
        return sensitveWordMapper.selectByName(sensitiveWord);
    }

    public Boolean update(SensitiveWord sensitiveWord) {
        return sensitveWordMapper.updateByPrimaryKey(sensitiveWord)==1;
    }
}
