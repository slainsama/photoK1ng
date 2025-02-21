package cn.gensokyo.y1ng.repository;

import cn.gensokyo.y1ng.model.Photo;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface ImageRepository extends JpaRepository<Photo, Long> {
}
