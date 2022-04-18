package com.example.demo.service;

import com.example.demo.model.request.RandomString;
import org.springframework.stereotype.Service;

@Service
public interface RandomService {
    public String randomString(RandomString randomString);
    public String randomPString();

}
