package cn.gensokyo.y1ng.controller;

import cn.gensokyo.y1ng.dto.requests.ImageUploadRequest;
import cn.gensokyo.y1ng.dto.response.ImageUploadResponse;
import cn.gensokyo.y1ng.service.ImageService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;


@RestController
@RequestMapping("/api/images")
public class ImageController {

    private final ImageService imageService;

    public ImageController(ImageService imageService) {
        this.imageService = imageService;
    }

    @PostMapping("/upload")
    public ResponseEntity<ImageUploadResponse> uploadController(@ModelAttribute ImageUploadRequest request) throws IOException {
        ImageUploadResponse response = imageService.uploadImage(request.getPhotos(),request.getPhotoComment(),request.getUploadDate());
        return ResponseEntity.ok(response);
    }
}
