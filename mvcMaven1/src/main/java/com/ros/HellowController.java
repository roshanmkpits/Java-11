package com.ros;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HellowController{

//    @RequestMapping(value = "/hello_world", method = RequestMethod.GET)
//    public String printHelloWorld(ModelMap modelMap){
//
//        // add attribute to load modelMap
//        modelMap.addAttribute("message",
//                "Hello World and Welcome to Spring MVC!");
//
//        // return the name of the file to be loaded "hello_world.jsp"
//        return "hello_world";
//    }


    @RequestMapping(value = "/hello_world")
    public String printHelloWorld(){



        // return the name of the file to be loaded "hello_world.jsp"
        return "hello_world";
    }


}