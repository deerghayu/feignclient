package com.example.feignclient.accessor;

import com.example.feignclient.model.Product;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient("restapiapp")
public interface RestApiAccessor {

    @RequestMapping(path = "/api/products/{id}", method = RequestMethod.GET)
    public Product getProductFromRestApi(@PathVariable (value="id") String id);
}
