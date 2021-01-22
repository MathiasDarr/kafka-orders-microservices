package org.mddarr.uirequestservice.controllers;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrdersController {

    @GetMapping("/api/orders")
    public String getProduts(){
        return "hello";
    }


}
