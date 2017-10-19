package com.shfc.mac;

import com.alibaba.dubbo.container.spring.SpringContainer;
import org.apache.log4j.Logger;

/**
 * @Package com.shfc.mac.MacMain
 * @Description: TODO
 * @Company:上海房产
 * @Copyright: Copyright (c) 2016
 * Author xiehaibin
 * @date 2017/3/29 10:05
 * version V1.0.0
 */
public class MacMain {
    private final static Logger logger = Logger.getLogger(MacMain.class);
    public static void main(String[] args) {
        init1(args);
    }

    /**
     * dubbo 默认的启动方式(更改启动的默认配置目录)
     * @param args
     */
    public static void init1(String ... args){
        //命令行方式 设置dubbo spring 方式的启动默认配置目录,并启动
        //-Ddubbo.spring.config=classpath:config/application-*.xml -Djava.ext.dirs=./lib com.alibaba.dubbo.container.Main

        //代码更改 dubbo spring方式启动的默认配置目录
        String DEFAULT_SPRING_CONFIG = "classpath*:config/application-*.xml";
        System.setProperty(SpringContainer.SPRING_CONFIG, DEFAULT_SPRING_CONFIG);
        com.alibaba.dubbo.container.Main.main(args);
    }
}
