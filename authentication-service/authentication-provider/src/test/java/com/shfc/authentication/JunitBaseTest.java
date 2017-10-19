package com.shfc.authentication;

import org.junit.Ignore;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(
        locations = {"classpath:config/application-common.xml",
                    "classpath:config/application-mybatis.xml",
//                  "classpath:config/application-provider.xml",
                    "classpath:config/application-plugins.xml" })
@RunWith(SpringJUnit4ClassRunner.class)
@Ignore
public class JunitBaseTest {

}
