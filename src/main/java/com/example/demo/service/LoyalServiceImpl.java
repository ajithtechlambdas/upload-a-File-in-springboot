package com.example.demo.service;

import com.example.demo.utils.FileUploadUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
public class LoyalServiceImpl implements LoyalService {

@Value("${app.pdf.upload-dir:./loyal/employeePdf}")
    private String uploadFloder;


    @Override
    public String upload(MultipartFile pdf) throws IOException {
        String filename= pdf.getOriginalFilename();
       return FileUploadUtils.uploadFiletoVps(uploadFloder,pdf,filename);

    }
}
