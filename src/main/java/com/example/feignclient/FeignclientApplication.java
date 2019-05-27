package com.example.feignclient;

import com.example.feignclient.accessor.RestApiAccessor;
import com.example.feignclient.model.Product;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
public class FeignclientApplication implements CommandLineRunner {

    public static final Logger LOG = LoggerFactory.getLogger(FeignclientApplication.class);

    @Autowired
    private RestApiAccessor restApiAccessor;

    public static void main(String[] args) {
        SpringApplication.run(FeignclientApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        Product productFromFeignClient = restApiAccessor.getProductFromRestApi("84fa1e5e-f663-47fa-a609-c8781d20b5f6");
        LOG.info("Product from restapiapp:" + productFromFeignClient.toString());
    }
}
