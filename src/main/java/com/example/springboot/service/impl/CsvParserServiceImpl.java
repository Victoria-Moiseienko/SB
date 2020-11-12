package com.example.springboot.service.impl;

import com.example.springboot.dto.ReviewDto;
import com.example.springboot.service.CsvParserService;
import com.opencsv.CSVParser;
import org.springframework.stereotype.Service;

@Service
public class CsvParserServiceImpl implements CsvParserService {
    private static final int ID_IND = 0;
    private static final int PRODUCT_ID_IND = 1;
    private static final int USER_ID_IND = 2;
    private static final int PROFILE_NAME_IND = 3;
    private static final int HELPFULNESS_NUMERATOR_IND = 4;
    private static final int HELPFULNESS_DENOMINATOR_IND = 5;
    private static final int SCORE_IND = 6;
    private static final int TIME_IND = 7;
    private static final int SUMMARY_IND = 8;
    private static final int TEXT_IND = 9;

    @Override
    public ReviewDto parseLine(String str) {
        CSVParser csvParser = new CSVParser();
        ReviewDto dto = new ReviewDto();
        try {
            String[] values = csvParser.parseLine(str);
            dto.setId(Long.parseLong(values[ID_IND].trim()));
            dto.setProductId(values[PRODUCT_ID_IND].trim());
            dto.setUserId(values[USER_ID_IND].trim());
            dto.setProfileName(values[PROFILE_NAME_IND].trim());
            dto.setHelpfulnessNumerator(Integer.parseInt(values[HELPFULNESS_NUMERATOR_IND].trim()));
            dto.setHelpfulnessDenominator(
                    Integer.parseInt(values[HELPFULNESS_DENOMINATOR_IND].trim()));
            dto.setScore(Integer.parseInt(values[SCORE_IND].trim()));
            dto.setTime(Long.parseLong(values[TIME_IND].trim()));
            dto.setSummary(values[SUMMARY_IND].trim());
            dto.setText(values[TEXT_IND].trim());
        } catch (Exception e) {
            throw new RuntimeException("Line has not been parsed", e);
        }
        return dto;
    }
}
