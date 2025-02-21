package cn.gensokyo.y1ng.service;

import cn.gensokyo.y1ng.dto.response.BatchGetByPageResponse;

public interface BatchGetByPageService {
    BatchGetByPageResponse getBatchByPage(int page, int size);
}
