package cn.gensokyo.y1ng.service.impl;


import cn.gensokyo.y1ng.dto.response.BatchGetByPageResponse;
import cn.gensokyo.y1ng.model.Photo;
import cn.gensokyo.y1ng.repository.ImageRepository;
import cn.gensokyo.y1ng.service.BatchGetByPageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public class BatchGetByPageServiceImpl implements BatchGetByPageService {

    @Autowired
    private ImageRepository imageRepository;

    @Override
    public BatchGetByPageResponse getBatchByPage(int page, int size) {
        Sort sort=Sort.by(Sort.Order.desc("timeStamp"));
        PageRequest pageRequest=PageRequest.of(page, size, sort);
        Page<Photo> images=imageRepository.findAll(pageRequest);
        List<Photo> photoList = images.getContent();
        Photo[] photoArray=photoList.toArray(new Photo[0]);


        return BatchGetByPageResponse.builder().pageSize(size).pageTotal(images.getTotalPages()).images(photoArray).build();
    }
}
