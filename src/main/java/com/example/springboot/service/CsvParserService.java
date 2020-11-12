package com.example.springboot.service;

import com.example.springboot.dto.ReviewDto;

public interface CsvParserService {
    ReviewDto parseLine(String str);
}
