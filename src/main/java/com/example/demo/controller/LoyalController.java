package com.example.demo.controller;

import com.example.demo.service.LoyalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping(path = "/loyal")
public class LoyalController {

    @Autowired
    public LoyalService loyalService;

    @PostMapping
    public String uploadPdf(@RequestPart(value = "pdf") MultipartFile pdf) throws IOException {
        return loyalService.upload(pdf);
    }
}
