package com.windyang.springdemo0201.dto;

import java.util.HashMap;
import java.util.Map;

/**
 * @author windyang
 */
public class MyDictionary {
        Map<String, String> wordMap;

        public MyDictionary() {
            wordMap = new HashMap<String, String>();
        }
        public void add(final String word, final String meaning) {
            wordMap.put(word, meaning);
        }
        public String getMeaning(final String word) {
            return wordMap.get(word);
        }
    }