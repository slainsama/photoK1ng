package cn.gensokyo.y1ng.dto.model;


import cn.gensokyo.y1ng.model.Photo;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Batch {
    private String batchId;
    private Photo[] photos;
}
