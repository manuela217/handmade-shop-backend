package com.handmade.ecommerce.backend.application;

import org.springframework.web.multipart.MultipartFile;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class UploadFile {
    private static final String FOLDER = "src/main/resources/static/images/";
    private static final String IMG_DEFAULT = "default.jpg";
    private static final String URL = "http://localhost:8080/images/";

    public String upload(MultipartFile multipartFile) throws IOException {
        if (multipartFile!=null) {
            byte [] bytes = multipartFile.getBytes();
            Path path = Paths.get(FOLDER+multipartFile.getOriginalFilename());
            Files.write(path, bytes);
            return URL+multipartFile.getOriginalFilename();
        }
        return URL+IMG_DEFAULT;
    }

    public void delete(String nameFile) {
        File file = new File(FOLDER+nameFile);
        if (file.exists()) {
            file.delete();
        }
    }
}
