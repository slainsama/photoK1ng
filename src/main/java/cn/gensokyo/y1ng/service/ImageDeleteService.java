package cn.gensokyo.y1ng.service;

import cn.gensokyo.y1ng.dto.request.ImageDeleteRequest;
import cn.gensokyo.y1ng.dto.response.ImageDeleteResponse;

import java.io.IOException;

public interface ImageDeleteService {
    ImageDeleteResponse deleteImage(Long imageId) throws IOException;
}
