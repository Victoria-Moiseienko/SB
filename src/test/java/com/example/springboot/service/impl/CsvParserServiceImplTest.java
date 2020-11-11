package com.example.springboot.service.impl;

import static org.junit.jupiter.api.Assertions.assertThrows;
import com.example.springboot.dto.ReviewDto;
import java.util.List;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

class CsvParserServiceImplTest {
    private static final List RECORDS = List.of(
            "4,B000UA0QIQ,A395BORC6FGVXV,Karl,3,3,2,1307923200,Medicine," +
                    "The flavor is very medicinal."
    );
    private static final List WRONG_FORMAT_RECORDS = List.of(
            "wrong num,B000UA0QIQ,A395BORC6FGVXV,Karl,3,3,2,1307923200,Medicine," +
                    "The flavor is very medicinal."
    );

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
                new CsvParserServiceImpl().parseCsvRecords(RECORDS).getReviewDtoList().get(0));
    }

    @Test
    public void parseWrongFormatRecords() {
        assertThrows(RuntimeException.class, () -> {
            new CsvParserServiceImpl().parseCsvRecords(WRONG_FORMAT_RECORDS);
        });
    }

    @Test
    public void parseNullListRecords() {
        assertThrows(RuntimeException.class, () -> {
            new CsvParserServiceImpl().parseCsvRecords(null);
        });
    }
}
