package demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.ResponseBody;

import demo.bean.Message;

@Controller
public class HelloController {
    @Autowired
    private Message message;
    @GetMapping(path = "/hello")
    @ResponseBody
    public String message() {
        return message.get();
    }
}