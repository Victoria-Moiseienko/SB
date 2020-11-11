package com.example.springboot.service.impl;

import com.example.springboot.dto.ReviewDto;
import com.example.springboot.dto.ReviewListDto;
import com.example.springboot.service.CsvParserService;
import com.opencsv.CSVParser;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class CsvParserServiceImpl implements CsvParserService {

    @Override
    public ReviewListDto parseCsvRecords(List<String> records) {
        List<ReviewDto> parsedRecords = new ArrayList<>();
        for (String str : records) {
            parsedRecords.add(parseLine(str));
        }
        return new ReviewListDto(parsedRecords);
    }

    private ReviewDto parseLine(String str) {
        CSVParser csvParser = new CSVParser();
        ReviewDto dto = new ReviewDto();
        try {
            String[] values = csvParser.parseLine(str);
            dto.setId(Long.parseLong(values[0].trim()));
            dto.setProductId(values[1].trim());
            dto.setUserId(values[2].trim());
            dto.setProfileName(values[3].trim());
            dto.setHelpfulnessNumerator(Integer.parseInt(values[4].trim()));
            dto.setHelpfulnessDenominator(Integer.parseInt(values[5].trim()));
            dto.setScore(Integer.parseInt(values[6].trim()));
            dto.setTime(Long.parseLong(values[7].trim()));
            dto.setSummary(values[8].trim());
            dto.setText(values[9].trim());
        } catch (Exception e) {
            throw new RuntimeException("Line has not been parsed", e);
        }
        return dto;
    }
}
