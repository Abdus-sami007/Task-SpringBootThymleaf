package com.jsp.project_thymeleaf.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class MyController {
    
    @GetMapping("/")
    public String loadmain()
    {
        return "index";
    }

    @GetMapping("/otp")
    public String getOtp(ModelMap map)
    {
        int otp = new Random().nextInt(1000,10000);
        map.put("otp",otp);
        return "index";
    }

    @GetMapping("/toss")
    public String getToss(ModelMap map)
    {
        String[] toss={"head","tail"};
        map.put("toss", toss[new Random().nextInt(0,2)]);
        return "index";
    }
    
    @GetMapping("/color")
    public String getColor(ModelMap map)
    {
        List<String> colors = Arrays.asList("Red","blue","green","yellow","orange","purple","pink","black","grey");
        String color =colors.get(new Random().nextInt(0,colors.size()));
        map.put("color",color);
        return "index";
    }

    @GetMapping("/message")
    public String getMessage(@RequestParam String message, @RequestParam String color, ModelMap map)
    {
         map.put("message",message);
         map.put("color1",color);
         return "index";
    }
    
    @GetMapping("/calc")
    public String calculator(@RequestParam double num1, @RequestParam double num2, @RequestParam String operation, ModelMap map)
    {
        map.put("num1", num1);
        map.put("num2", num2);

        switch (operation) {
            case "add" :
                map.put("ans",num1+num2);
                break;

            case "sub" :
                map.put("ans",num1-num2);
                break;  

            case "mul" :
                map.put("ans",num1*num2);
                break;

            case "div" :
                map.put("ans",num1/num2);
                break;

            default:
                break;

        }

        return "index";

    }
    
}