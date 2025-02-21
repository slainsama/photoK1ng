package cn.gensokyo.y1ng.service.impl;

import cn.gensokyo.y1ng.dto.response.ImageUploadResponse;
import cn.gensokyo.y1ng.model.Photo;
import cn.gensokyo.y1ng.repository.ImageRepository;
import cn.gensokyo.y1ng.service.ImageUploadService;
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
public class ImageUploadServiceImpl implements ImageUploadService {

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
        String batch= String.valueOf(UUID.randomUUID());
        int i = 0;
        for(MultipartFile file:files){
            String fileName = UUID.randomUUID()+"."+getFileExtension(file);

            Path path= Paths.get(dirPath,fileName);
            Files.copy(file.getInputStream(),path);
            Photo photo= Photo.builder().batch(batch).photoComment(comment).filePath(fileName).timeStamp(System.currentTimeMillis()).build();
            imageRepository.save(photo);
            long photoId= photo.getPhotoId();
            photoIds[i]=photoId;
            i++;
        }
        return ImageUploadResponse.builder().id(photoIds).batch(batch).status("ok").build();
    }
}
