package com.shfc.authentication.service;

import com.alibaba.fastjson.JSON;
import com.shfc.authentication.JunitBaseTest;
import com.shfc.authentication.dto.AuthenticationNameDTO;
import com.shfc.common.result.ResultDO;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Copyright: Copyright (c) 2016
 * Company:上海房产
 *
 * @author wky
 * @version V1.0
 * @create 2017-03-06 14:06
 **/
public class AuthenticationServiceTest extends JunitBaseTest {
    @Autowired
    private AuthenticationService authenticationService;
    @Test
    public void testAuthenticationByInfo(){
        AuthenticationNameDTO dto=new AuthenticationNameDTO();
        dto.setId("341201791001182");
        dto.setName("周晓晓");
        dto.setMerchantId(1L);
        dto.setChannelNo("999");
        ResultDO<Boolean> resultDO=authenticationService.authenticationByInfo(dto);
        System.out.println(JSON.toJSONString(resultDO));
    }

    @Test
    public void testIdentityId(){
        AuthenticationNameDTO dto=new AuthenticationNameDTO();
        dto.setId("310109198809264011");
        dto.setName("周晓晓");
        dto.setMerchantId(1L);
        dto.setChannelNo("999");
        ResultDO<Boolean> resultDO=authenticationService.identityId(dto);
        System.out.println(JSON.toJSONString(resultDO));
    }
}
