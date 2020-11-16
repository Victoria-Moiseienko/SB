package com.example.springboot.service.impl;

import static org.junit.jupiter.api.Assertions.assertThrows;
import com.example.springboot.dto.ReviewDto;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

class CsvParserServiceImplTest {
    private static final String RECORD = "4,B000UA0QIQ,A395BORC6FGVXV,Karl,3,3,2,1307923200,Medicine,"
            + "The flavor is very medicinal.";
    private static final String WRONG_FORMAT_RECORD =
            "wrong num,B000UA0QIQ,A395BORC6FGVXV,Karl,3,3,2,1307923200,Medicine,"
                    + "The flavor is very medicinal.";

    @Test
    public void parseOk() {
        ReviewDto expectedDto = new ReviewDto();
            expectedDto.setId(4L);
            expectedDto.setProductId("B000UA0QIQ");
            expectedDto.setUserId("A395BORC6FGVXV");
            expectedDto.setProfileName("Karl");
            expectedDto.setHelpfulnessNumerator(3);
            expectedDto.setHelpfulnessDenominator(3);
            expectedDto.setScore(2);
            expectedDto.setTime(1307923200L);
            expectedDto.setSummary("Medicine");
            expectedDto.setText("The flavor is very medicinal.");
        Assert.assertEquals("FAILED! Unexpected result",
                expectedDto,
                new ReviewCsvParserServiceImpl().parseLine(RECORD));
    }

    @Test
    public void parseWrongFormatRecords() {
        assertThrows(RuntimeException.class, () -> {
            new ReviewCsvParserServiceImpl().parseLine(WRONG_FORMAT_RECORD);
        });
    }

    @Test
    public void parseNullListRecords() {
        assertThrows(RuntimeException.class, () -> {
            new ReviewCsvParserServiceImpl().parseLine(null);
        });
    }
}
