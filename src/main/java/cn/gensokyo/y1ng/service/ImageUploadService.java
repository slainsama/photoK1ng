package cn.gensokyo.y1ng.service;

import cn.gensokyo.y1ng.dto.response.ImageUploadResponse;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.time.LocalDate;


public interface ImageUploadService {
    ImageUploadResponse uploadImage(MultipartFile[] file, String comment, LocalDate date)throws IOException;

}
