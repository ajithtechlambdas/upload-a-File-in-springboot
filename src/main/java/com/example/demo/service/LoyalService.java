package com.example.demo.service;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface LoyalService {
    String upload(MultipartFile pdf) throws IOException;

    byte[] display(String fileName);

}
