package com.example.soapclientnumbertowords.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import java.math.BigDecimal;
import java.math.BigInteger;
import com.example.soapclientnumbertowords.wsdl.*;

public class NumberToWordsClientService extends WebServiceGatewaySupport {
    private static final Logger log = LoggerFactory.getLogger(NumberToWordsClientService.class);

    public NumberToWordsResponse numberToWordsRequest(BigInteger val) {
        NumberToWords request = new NumberToWords();

        request.setUbiNum(val);

        NumberToWordsResponse response = (NumberToWordsResponse) getWebServiceTemplate().marshalSendAndReceive(request);
        log.info("NumberToWords request sent");

        return response;
    }

    public NumberToDollarsResponse numberToDollarsResponse(BigDecimal val) {
        NumberToDollars request = new NumberToDollars();

        request.setDNum(val);

        NumberToDollarsResponse response = (NumberToDollarsResponse) getWebServiceTemplate().marshalSendAndReceive(request);
        log.info("NumberToDollars request sent");

        return response;
    }
}
