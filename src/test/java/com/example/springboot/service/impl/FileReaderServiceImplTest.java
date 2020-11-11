package com.example.springboot.service.impl;

import com.example.springboot.service.FileReaderService;
import org.junit.jupiter.api.Test;
import org.junit.Assert;

import java.util.ArrayList;
import java.util.List;

class FileReaderServiceImplTest {
    private static final String EMPTY_FILE_NAME = "test1";
    private static final String CSV_FILE_NAME = "test2.csv";
    private static final List<List<String>> EMPTY_RESULT = new ArrayList<>();

    @Test
    public void readFromEmptyFile() {
        FileReaderService fileReaderService = new FileReaderServiceImpl();
        List<List<String>> actualResult = fileReaderService.read(EMPTY_FILE_NAME);
        Assert.assertEquals("FAILED! Result should be empty",
                EMPTY_RESULT, actualResult);
    }

    @Test
    public void readFromCsvFile() {
        FileReaderService fileReaderService = new FileReaderServiceImpl();
        List<String> expectedResult = List.of("Id", "ProductId", "UserId", "ProfileName",
                "HelpfulnessNumerator", "HelpfulnessDenominator", "Score", "Time", "Summary", "Text");
        List<List<String>> actualResult = fileReaderService.read(CSV_FILE_NAME);
        Assert.assertEquals("FAILED! Size of result should be 3",
                3, actualResult.size());
        Assert.assertEquals("FAILED! Size of result should be 9",
                expectedResult, actualResult.get(0));
    }

}