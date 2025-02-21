package cn.gensokyo.y1ng.dto.response;


import cn.gensokyo.y1ng.dto.model.Batch;
import cn.gensokyo.y1ng.model.Photo;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;




@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BatchGetByPageResponse {
    private int page;
    private int pageTotal;
    private int pageSize;
    private Photo[] images;
}
