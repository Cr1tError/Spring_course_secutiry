package com.org.mk.security.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MyController {


    @GetMapping("/")
    public String getInfoAllEmps(){
        return "view_for_all_emps";
    }
    @GetMapping("/hr_info")
    public String infoForHrOnly(){
        return "view_for_hr";
    }

    @GetMapping("/manager_info")
    public String infoForManagerOnly(){
        return "view_for_managers";
    }
}
