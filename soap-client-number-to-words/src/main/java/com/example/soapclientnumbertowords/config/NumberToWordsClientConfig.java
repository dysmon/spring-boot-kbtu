package com.example.soapclientnumbertowords.config;

import com.example.soapclientnumbertowords.service.NumberToWordsClientService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;

@Configuration
public class NumberToWordsClientConfig {
    @Bean
    public Jaxb2Marshaller marshaller() {
        Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
        marshaller.setContextPath("com.example.soapclientnumbertowords.wsdl");
        return marshaller;
    }

    @Bean
    public NumberToWordsClientService numberToWordsClient(Jaxb2Marshaller marshaller) {
        var client = new NumberToWordsClientService();
        client.setDefaultUri("https://www.dataaccess.com/webservicesserver/numberconversion.wso");
        client.setMarshaller(marshaller);
        client.setUnmarshaller(marshaller);

        return client;
    }
}
