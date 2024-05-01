package com.example.soapclient;

import com.example.soapclient.wsdl.GetCountryResponse;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

@SpringBootTest
class SoapClientApplicationTests {

    @Autowired
    CountryClient countryClient;

    @Test
    void contextLoads() {
    }

//     Integration tests
//    @Test
//    void testPoland() {
//        // Assign
//        String country = "Poland";
//        // Act
//        GetCountryResponse response = countryClient.getCountry(country);
//        // Assert
//        Assert.isTrue(response.getCountry().toString().equals(country),"hi");
//    }

}
