package cn.gensokyo.y1ng.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import org.jetbrains.annotations.NotNull;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDate;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class ImageUploadRequest {
    @NotNull
    private MultipartFile[] photos;

    private String photoComment;

    @NotNull
    private LocalDate uploadDate;
}
