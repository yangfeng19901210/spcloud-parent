package com.yf;

import com.codingapi.txlcn.tm.config.EnableTransactionManagerServer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * @projectName: spcloud-parent
 * @package: com.yf
 * @className: TxManagerApp
 * @author: yangfeng
 * @description: TODO
 * @date: 2022/11/25 16:06
 * @version: 1.0
 */
@SpringBootApplication
@EnableTransactionManagerServer
public class TxManagerApp {

    public static void main(String[] args) {
        ConfigurableApplicationContext configurableApplicationContext = SpringApplication.run(TxManagerApp.class, args);

    }
}
