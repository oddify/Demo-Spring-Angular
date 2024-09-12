package com.oddify.practice.productservice.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WebController {

//    @GetMapping(value = "/frontend")
@GetMapping(value = "/{path:[^\\.]*}")
    public String forwardToIndex() {

        // Forward to index.html for Angular routing to work
        return "forward:/index.html";

    }


}