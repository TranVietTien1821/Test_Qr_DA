package com.example.demoqr.controller;

import com.example.demoqr.config.ZXingHelper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@Controller
public class HelloControlle {
    @GetMapping("/hien-thi")
    public String hienThi(){
        UUID id = UUID.fromString("72A28F31-EE87-47CA-8729-470382842388");
//        String id = "-1094800-d-4d-234ff23";
        ZXingHelper.getBarCodeImage(String.valueOf(id),200,300);
        return "hello";
    }

    @GetMapping("/{id}")
    public String add(@PathVariable("id") String id, Model model){
        model.addAttribute("id",id);
        System.out.println(id);
        return "index";
    }
}
