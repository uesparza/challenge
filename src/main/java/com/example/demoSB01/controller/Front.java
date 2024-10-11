package com.example.demoSB01.controller;

import com.example.demoSB01.service.ServiceExp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;

@RestController
@RequestMapping("/api")
public class Front {

    @Autowired
    private ServiceExp serviceExp;

    @GetMapping("/expression/{input}")
    public int getExpression(@PathVariable String input) {
        return serviceExp.getExpression(input);
    }

    @GetMapping("/consecutive/{input}")
    public int getConsecutive(@PathVariable String input) {
        int[] arr = Arrays.stream(input.split(",")).mapToInt(Integer::parseInt).toArray();
        return serviceExp.getConsecutive(arr);
    }




}
