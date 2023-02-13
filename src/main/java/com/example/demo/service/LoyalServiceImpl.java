package com.example.demo.service;

import com.example.demo.utils.FileUploadUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import com.google.common.io.Files;

import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Path;
import java.nio.file.Paths;

@Service
public class LoyalServiceImpl implements LoyalService {

    @Value("${app.pdf.upload-dir:./loyal/employeePdf}")
    private String uploadFloder;


    @Override
    public String upload(MultipartFile pdf) throws IOException {
        String filename = pdf.getOriginalFilename();
        return FileUploadUtils.uploadFiletoVps(uploadFloder, pdf, filename);

    }

    @Override
    public byte[] display(String fileName) {
        try {
            Path file = Paths.get(uploadFloder).resolve(fileName);
            Resource resource = new UrlResource(file.toUri());
            if (resource.exists() || resource.isReadable()) {
                return Files.toByteArray(file.toFile());
            } else {
                throw new RuntimeException("Could not read the file!");
            }
        } catch (IOException e) {
            throw new RuntimeException("Error: " + e.getMessage());
        }
    }

    @Override
    public byte[] load(String filename) {
        {
            try {
                Path file = Paths.get(uploadFloder).resolve(filename);
                Resource resource = new UrlResource(file.toUri());
                if (resource.exists() || resource.isReadable()) {
                    return null;
                } else {
                    throw new RuntimeException("Could not read the file!");
                }
            } catch (MalformedURLException e) {
                throw new RuntimeException("Error: " + e.getMessage());
            }
        }
    }

}
