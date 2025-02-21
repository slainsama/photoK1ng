package cn.gensokyo.y1ng.service.impl;

import cn.gensokyo.y1ng.dto.response.ImageDeleteResponse;
import cn.gensokyo.y1ng.model.Photo;
import cn.gensokyo.y1ng.repository.ImageRepository;
import cn.gensokyo.y1ng.service.ImageDeleteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Collections;
import java.util.Optional;

@Service
public class ImageDeleteServiceImpl implements ImageDeleteService {

    @Value("${app.upload.dir}")
    private String dirPath;

    @Autowired
    private ImageRepository imageRepository;

    @Override
    public ImageDeleteResponse deleteImage(Long imageId) throws IOException {
        Photo photo = imageRepository.getReferenceById(imageId);
        String filePath =photo.getFilePath();
        Files.delete(Path.of(dirPath+"/"+filePath));
        imageRepository.delete(photo);
        return ImageDeleteResponse.builder().imageId(String.valueOf(imageId)).status("ok").build();
    }
}
