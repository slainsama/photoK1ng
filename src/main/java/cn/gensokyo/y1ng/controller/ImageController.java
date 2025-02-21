package cn.gensokyo.y1ng.controller;

import cn.gensokyo.y1ng.dto.request.BatchGetByPageRequest;
import cn.gensokyo.y1ng.dto.request.ImageDeleteRequest;
import cn.gensokyo.y1ng.dto.request.ImageUploadRequest;
import cn.gensokyo.y1ng.dto.response.BatchGetByPageResponse;
import cn.gensokyo.y1ng.dto.response.ImageDeleteResponse;
import cn.gensokyo.y1ng.dto.response.ImageUploadResponse;
import cn.gensokyo.y1ng.service.BatchGetByPageService;
import cn.gensokyo.y1ng.service.ImageDeleteService;
import cn.gensokyo.y1ng.service.ImageUploadService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;


@RestController
@RequestMapping("/api/images")
public class ImageController {

    private final ImageUploadService imageUploadService;

    private final ImageDeleteService imageDeleteService;

    private final BatchGetByPageService batchGetByPageService;

    public ImageController(ImageUploadService imageUploadService, ImageDeleteService imageDeleteService, BatchGetByPageService batchGetByPageService) {
        this.imageUploadService = imageUploadService;
        this.imageDeleteService = imageDeleteService;
        this.batchGetByPageService = batchGetByPageService;
    }

    @PostMapping("/upload")
    public ResponseEntity<ImageUploadResponse> uploadController(@ModelAttribute ImageUploadRequest request) throws IOException {
        ImageUploadResponse response = imageUploadService.uploadImage(request.getPhotos(),request.getPhotoComment(),request.getUploadDate());
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<ImageDeleteResponse> deleteController(@ModelAttribute ImageDeleteRequest request) throws IOException {
        ImageDeleteResponse response= imageDeleteService.deleteImage(request.getImageId());
        return ResponseEntity.ok(response);
    }

    @GetMapping("/getByPage")
    public ResponseEntity<BatchGetByPageResponse> getByPageController(@ModelAttribute BatchGetByPageRequest request) {
        BatchGetByPageResponse response= batchGetByPageService.getBatchByPage(request.getPage() ,request.getPageSize());
        return ResponseEntity.ok(response);
    }

}
