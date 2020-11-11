package com.example.springboot.dto;

import java.util.List;
import lombok.Data;

@Data
public class ReviewListDto {
    private List<ReviewDto> reviewDtoList;

    public ReviewListDto(List<ReviewDto> reviewDtoList) {
        this.reviewDtoList = reviewDtoList;
    }
}
