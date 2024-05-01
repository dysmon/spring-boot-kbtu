package com.example.casbinexample.service;

import com.example.casbinexample.model.Data;

public interface IDataService {
    void setState(String state);

    Data getSecuredData(String source);
}
