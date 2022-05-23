package com.codeup.springblog.services;


import org.springframework.stereotype.Service;

@Service
public class StringService {

    public String getWordInCaps(String word){
        return word.toUpperCase();
    }

//    public String limitLength(String string, int limit) {
//        if(limit > string.length(0, ))
//    }
}
