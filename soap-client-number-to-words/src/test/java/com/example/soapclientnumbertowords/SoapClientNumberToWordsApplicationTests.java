package com.example.soapclientnumbertowords;

import com.example.soapclientnumbertowords.service.NumberToWordsClientService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.math.BigInteger;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class SoapClientNumberToWordsApplicationTests {

    @Autowired
    NumberToWordsClientService client;

    @Test
    void contextLoads() {
    }

    @Test
    void testNumberToWords() {
        // Assign
        String expected = "one";

        // Act
        var actual = client.numberToWordsRequest(BigInteger.valueOf(1));

        // Assert
        assertEquals(expected, actual.getNumberToWordsResult().strip());
    }

    @Test
    void testNumberToDollarsSingular() {
        // Assign
        String expected = "one dollar";

        // Act
        var actual = client.numberToDollarsResponse(BigDecimal.valueOf(1));

        // Assert
        assertEquals(expected, actual.getNumberToDollarsResult().strip());
    }

    @Test
    void testNumberToDollarsPlural() {
        // Assign
        String expected = "one hundred and two dollars";

        // Act
        var actual = client.numberToDollarsResponse(BigDecimal.valueOf(102));

        // Assert
        assertEquals(expected, actual.getNumberToDollarsResult().strip());
    }
}
