package com.dsosedov.authclient.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AuthController {

    @GetMapping("/authorized")
    public String authorized() {
        return "index";
    }

}
