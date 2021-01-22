package org.mddarr.uirequestservice.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class InventoryController {

    @GetMapping("/api/products/")
    public String getProduts(){
        return "hello";
    }

}
