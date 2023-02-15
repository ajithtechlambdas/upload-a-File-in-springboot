package com.example.demo.controller;

import com.example.demo.service.LoyalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
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

    @GetMapping("/{fileName}")
    public ResponseEntity<byte[]> displayImage(@PathVariable String fileName){
        byte[] file = loyalService.display(fileName);
        return ResponseEntity.ok().contentType(MediaType.APPLICATION_PDF).body(file);
    }



}
