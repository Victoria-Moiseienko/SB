package com.example.springboot.service.impl;

import static org.junit.jupiter.api.Assertions.assertThrows;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.junit.Assert;

class FileReaderServiceImplTest {
    private static final String EMPTY_FILE_NAME = "test1";
    private static final String CSV_FILE_NAME = "test2.csv";
    private static final String CSV_FILE_WITHOUT_HEADER = "test3.csv";
    private static final String NOT_EXIST_FILE_NAME = "not_exist_file.txt";
    private static final List<List<String>> EMPTY_RESULT = new ArrayList<>();
    private static final String EXPECTED_RESULT =
            "Id,ProductId,UserId,ProfileName,HelpfulnessNumerator,HelpfulnessDenominator,Score,Time,Summary,Text";
    private static final String FILE_WITHOUT_HEADER_EXPECTED_RESULT =
            "5,B006K2ZZ7K,A1UQRSCLF8GW1T,\"Michael D. Bigham \"\"M. Wassir\"\"\",0,0,5,1350777600,"
                    + "Great taffy,\"Great taffy at a great price.  There was a wide assortment of yummy taffy."
                    + "  Delivery was very quick.  If your a taffy lover, this is a deal.\"";

    @Test
    public void readFromEmptyFile() {
        Assert.assertEquals("FAILED! Result should be empty",
                EMPTY_RESULT, new FileReaderServiceImpl().read(EMPTY_FILE_NAME));
    }

    @Test
    public void readFromCsvFile() {
        List<String> actualResult = new FileReaderServiceImpl().read(CSV_FILE_NAME);
        Assert.assertEquals("FAILED! Unexpected size of result list! ",
                3, actualResult.size());
        Assert.assertEquals("FAILED! Unexpected result! ",
                EXPECTED_RESULT, actualResult.get(0));
    }

    @Test
    public void readWithoutHeaderFile() {
        List<String> actualResult = new FileReaderServiceImpl().read(CSV_FILE_WITHOUT_HEADER);
        Assert.assertEquals("FAILED! Unexpected result! ",
                FILE_WITHOUT_HEADER_EXPECTED_RESULT, actualResult.get(0));
    }

    @Test
    public void readFromNotExistFile() {
        assertThrows(RuntimeException.class, () -> {
            new FileReaderServiceImpl().read(NOT_EXIST_FILE_NAME);
        });
    }
}
