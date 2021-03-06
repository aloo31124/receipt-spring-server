package com.example.receiptspringserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@SpringBootApplication
public class ReceiptSpringServerApplication {

    @RequestMapping("/")
    @ResponseBody
    String home(){
        return "loulou receipt Hello world! :D";
    }

    public static void main(String[] args) {
        SpringApplication.run(ReceiptSpringServerApplication.class, args);
    }

}
