package com.shfc.cloud.common.ao;

import com.shfc.cloud.account.dto.MerchantInfoDTO;
import com.shfc.cloud.account.query.UserInfoQuery;
import com.shfc.cloud.account.service.AccountService;
import com.shfc.cloud.cloudbase.dto.ChannelDTO;
import com.shfc.cloud.cloudbase.service.ChannelService;
import com.shfc.cloud.constant.ErrorConstant;
import com.shfc.common.base.ValidateHelper;
import com.shfc.common.result.ResultDO;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 * @Package com.shfc.cloud.common.ao.BaseAO
 * @Description: TODO
 * @Company:上海房产
 * @Copyright: Copyright (c) 2016
 * Author zhanghz
 * @date 2017/3/30 11:22
 * version V1.0.0
 */
@Service
public class BaseAO {

	@Value("${php.merchant.no}")
	private String merchant_number_php;

	@Autowired
	private AccountService accountService;

	@Autowired
	private ChannelService channelService;

	protected ResultDO checkCommonData(Long merchantId, String channelNo) {
		ResultDO checkDO = new ResultDO();
		if(merchantId==null){
			checkDO.setSuccess(false);
			checkDO.setErrCode(ErrorConstant.NULL_MERCHANT_ID.getCode());
			checkDO.setErrMsg(ErrorConstant.NULL_MERCHANT_ID.getMsg());
			return checkDO;
		}

		if(ValidateHelper.isEmpty(channelNo) &&(!merchant_number_php.equals(com.shfc.common.base.StringUtils.toString(merchantId,"")))){
			checkDO.setSuccess(false);
			checkDO.setErrCode(ErrorConstant.NULL_CHANNEL_NO.getCode());
			checkDO.setErrMsg(ErrorConstant.NULL_CHANNEL_NO.getMsg());
			return checkDO;
		}

		UserInfoQuery merchantQuery = new UserInfoQuery();
		merchantQuery.setMerchantId(merchantId);
		ResultDO<MerchantInfoDTO> merchantDO = accountService.merchantInfo(merchantQuery);
		if(!merchantDO.isSuccess()||merchantDO.getData()==null){
			checkDO.setSuccess(false);
			checkDO.setErrCode(ErrorConstant.INVALID_MERCHANT.getCode());
			checkDO.setErrMsg(ErrorConstant.INVALID_MERCHANT.getMsg());
			return checkDO;
		}else{
			MerchantInfoDTO merchant = merchantDO.getData();
			if(!("3".equals(merchant.getCheckStatus()))){
				checkDO.setSuccess(false);
				checkDO.setErrCode(ErrorConstant.INVALID_MERCHANT.getCode());
				checkDO.setErrMsg(ErrorConstant.INVALID_MERCHANT.getMsg());
				return checkDO;
			}
		}
		if(!merchant_number_php.equals(com.shfc.common.base.StringUtils.toString(merchantId,""))){
			ResultDO<ChannelDTO> channelDO = channelService.queryChannelByNo(channelNo);
			if(!channelDO.isSuccess() || channelDO.getData()==null){
				checkDO.setSuccess(false);
				checkDO.setErrCode(ErrorConstant.INVALID_CHANNEL_NO.getCode());
				checkDO.setErrMsg(ErrorConstant.INVALID_CHANNEL_NO.getMsg());
				return checkDO;
			}else{
				ChannelDTO channel = channelDO.getData();
				if(!StringUtils.equals(channel.getStatus(), "2")){//2：已开通
					checkDO.setSuccess(false);
					checkDO.setErrCode(ErrorConstant.INVALID_CHANNEL_NO.getCode());
					checkDO.setErrMsg(ErrorConstant.INVALID_CHANNEL_NO.getMsg());
					return checkDO;
				}else if(!StringUtils.equals(merchantId+"",channel.getMerchantNo())){
					checkDO.setSuccess(false);
					checkDO.setErrCode(ErrorConstant.DIFF_CHANNEL_NO.getCode());
					checkDO.setErrMsg(ErrorConstant.DIFF_CHANNEL_NO.getMsg());
					return checkDO;
				}

			}
		}

		checkDO.setSuccess(true);
		return checkDO;
	}

	protected ResultDO checkCommonQueryData(Long merchantId, String channelNo) {
		ResultDO checkDO = new ResultDO();
		if(merchantId==null){
			checkDO.setSuccess(false);
			checkDO.setErrCode(ErrorConstant.NULL_MERCHANT_ID.getCode());
			checkDO.setErrMsg(ErrorConstant.NULL_MERCHANT_ID.getMsg());
			return checkDO;
		}

		if(ValidateHelper.isEmpty(channelNo) &&(!merchant_number_php.equals(com.shfc.common.base.StringUtils.toString(merchantId,"")))){
			checkDO.setSuccess(false);
			checkDO.setErrCode(ErrorConstant.NULL_CHANNEL_NO.getCode());
			checkDO.setErrMsg(ErrorConstant.NULL_CHANNEL_NO.getMsg());
			return checkDO;
		}

		UserInfoQuery merchantQuery = new UserInfoQuery();
		merchantQuery.setMerchantId(merchantId);
		ResultDO<MerchantInfoDTO> merchantDO = accountService.merchantInfo(merchantQuery);
		if(!merchantDO.isSuccess()||merchantDO.getData()==null){
			checkDO.setSuccess(false);
			checkDO.setErrCode(ErrorConstant.INVALID_MERCHANT.getCode());
			checkDO.setErrMsg(ErrorConstant.INVALID_MERCHANT.getMsg());
			return checkDO;
		}else{
			MerchantInfoDTO merchant = merchantDO.getData();
			if(!("3".equals(merchant.getCheckStatus()))){
				checkDO.setSuccess(false);
				checkDO.setErrCode(ErrorConstant.INVALID_MERCHANT.getCode());
				checkDO.setErrMsg(ErrorConstant.INVALID_MERCHANT.getMsg());
				return checkDO;
			}
		}
		if(!merchant_number_php.equals(com.shfc.common.base.StringUtils.toString(merchantId,""))){
			ResultDO<ChannelDTO> channelDO = channelService.queryAllChannelByNo(channelNo);
			if(!channelDO.isSuccess() || channelDO.getData()==null){
				checkDO.setSuccess(false);
				checkDO.setErrCode(ErrorConstant.INVALID_CHANNEL_NO.getCode());
				checkDO.setErrMsg(ErrorConstant.INVALID_CHANNEL_NO.getMsg());
				return checkDO;
			}
		}

		checkDO.setSuccess(true);
		return checkDO;
	}

}
