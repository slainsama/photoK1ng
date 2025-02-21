package cn.gensokyo.y1ng.service.impl;

import cn.gensokyo.y1ng.dto.response.ImageUploadResponse;
import cn.gensokyo.y1ng.model.Photo;
import cn.gensokyo.y1ng.repository.ImageRepository;
import cn.gensokyo.y1ng.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.UUID;


@Service
public class ImageServiceImpl implements ImageService {

    @Value("${app.upload.dir}")
    private String dirPath;

    @Autowired
    private ImageRepository imageRepository;

    private String getFileExtension(MultipartFile file) {
        String fileName=file.getOriginalFilename();
        if (fileName != null) {
            return fileName.substring(fileName.lastIndexOf(".")+1);
        }
        return null;
    }

    @Override
    public ImageUploadResponse uploadImage(MultipartFile[] files, String comment, LocalDate date) throws IOException {
        long[] photoIds = new long[files.length];
        int i = 0;
        for(MultipartFile file:files){
            String fileName = UUID.randomUUID()+"."+getFileExtension(file);
            Path path= Paths.get(dirPath,fileName);
            Files.copy(file.getInputStream(),path);
            Photo photo= Photo.builder().photoComment(comment).filePath(fileName).build();
            imageRepository.save(photo);
            long photoId= photo.getPhotoId();
            photoIds[i]=photoId;
            i++;
        }
        return ImageUploadResponse.builder().Id(photoIds).build();
    }
}
