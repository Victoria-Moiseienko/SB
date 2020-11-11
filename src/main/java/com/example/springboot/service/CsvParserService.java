package com.example.springboot.service;

import com.example.springboot.dto.ReviewListDto;
import java.util.List;

public interface CsvParserService {
    ReviewListDto parseCsvRecords(List<String> records);
}
