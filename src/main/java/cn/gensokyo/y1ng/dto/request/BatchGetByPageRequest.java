package cn.gensokyo.y1ng.dto.request;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BatchGetByPageRequest {
    private int page;
    private int pageSize;

}
