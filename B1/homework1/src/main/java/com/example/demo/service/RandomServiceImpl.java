package com.example.demo.service;

import com.example.demo.model.request.RandomString;
import org.springframework.stereotype.Component;

import java.sql.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
@Component
public class RandomServiceImpl implements RandomService {
    private static final String alpha = "abcdefghijklmnopqrstuvwxyz"; // a-z
    private static final String alphaUpperCase = alpha.toUpperCase(); // A-Z
    private static final String digits = "0123456789"; // 0-9
    private static final String specials = "~=+%^*/()[]{}/!@#$?|";
    private static final String ALPHA_NUMERIC = alpha + alphaUpperCase + digits;
    private static final String ALL = alpha + alphaUpperCase + digits + specials;
    private static Random generator = new Random();
    private static Map<Integer,String> pList = new HashMap<>();

    public static int randomNumber(int min, int max) {
        return generator.nextInt((max - min) + 1) + min;
    }

    @Override
    public String randomString(RandomString randomString) {
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<randomString.getNumberOfCharacter();i++){
            int number = randomNumber(0, ALPHA_NUMERIC.length()-1);
            char ch = ALPHA_NUMERIC.charAt(number);
            sb.append(ch);
        }
        return sb.toString();
    }


    @Override
    public String randomPString() {
       int numRan = (int)randomNumber(1,4);
       return pList.get(numRan);
    }

    static {
        pList.put(1,"Kiến tha lâu đầy tổ");
        pList.put(2,"Có công mài sắt, có ngày nên kim");
        pList.put(3,"Không thầy đố mày làm nên");
        pList.put(4,"Học thầy không tày học bạn");
    }


}
