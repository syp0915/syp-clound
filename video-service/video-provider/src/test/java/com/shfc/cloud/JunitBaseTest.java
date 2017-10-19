package com.shfc.cloud;

import org.junit.Ignore;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @Package com.shfc.cloud.account.JunitBaseTest
 * @Description: TODO
 * @Company:上海房产
 * @Copyright: Copyright (c) 2016
 * Author wliao
 * @date 2017/3/27 14:56
 * version V1.0.0
 */
@ContextConfiguration(
        locations = {"classpath:config/application-common.xml",
                "classpath:config/application-consumer.xml",
                "classpath:config/application-mybatis.xml",
                "classpath:config/application-plugins.xml",
                "classpath:config/application-provider.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
@Ignore
public class JunitBaseTest {
}
