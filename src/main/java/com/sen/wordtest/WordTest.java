package com.sen.wordtest;

import java.util.*;

public class WordTest {

    private static final String[] DEFAULT_DICTIONARY = new String[]{"i", "like", "sam", "sung", "samsung", "mobile", "ice", "cream", "and", "man go"};

    private static List<StringBuilder> getPossibleOutputs(String mappedString, int level, String[] dictionary, Set<String> output) {

        List<StringBuilder> result = new ArrayList<StringBuilder>();

        if(level == 0) {
            for (int i = 0; i < dictionary.length; i++) {
                result.add(new StringBuilder(dictionary[i]));
                if(mappedString.equals(dictionary[i].replaceAll(" ", ""))) {
                    output.add(dictionary[i]);
                }
            }
            return result;
        }
        for (int i = 0; i < dictionary.length; i++) {
            String[] subDic = new String[dictionary.length - 1];
            for (int j = 0; j < dictionary.length; j++) {
                if(j < i) {
                    subDic[j] = dictionary[j];
                } else if(j > i) {
                    subDic[j - 1] = dictionary[j];
                }
            }
            List<StringBuilder> tails = getPossibleOutputs(mappedString, level - 1, subDic, output);
            for (int j = 0; j < tails.size(); j++) {
                StringBuilder tmp = new StringBuilder(dictionary[i] + " " + tails.get(j));
                if(mappedString.equals(tmp.toString().replaceAll(" ", ""))) {
                    output.add(tmp.toString());
                }
                result.add(tmp);
            }
        }
        return result;
    }

    private static String getAllPossibleOutput(String mappedString, String[] dictionary) {
        Set<String> result = new HashSet<String>();
        getPossibleOutputs(mappedString, dictionary.length - 1, dictionary, result);
        StringBuilder output = new StringBuilder();
        for(String tmp : result) {
            output.append(tmp + "\n");
        }
        return output.toString();
    }

    public static String stage1Method(String mappedString) {
        if(null == mappedString || "".equals(mappedString)) return "";
        return getAllPossibleOutput(mappedString, filerDictionary(mappedString, DEFAULT_DICTIONARY));
    }

    public static String stage2Method(String mappedString, String[] customDictionary) {
        if(null == mappedString || "".equals(mappedString) || null == customDictionary || customDictionary.length == 0) return "";
        return getAllPossibleOutput(mappedString, filerDictionary(mappedString, customDictionary));
    }

    public static String stage3Method(String mappedString, String[] customDictionary) {
        if(null == mappedString || "".equals(mappedString)) return "";
        if(null == customDictionary || customDictionary.length == 0) {
            return getAllPossibleOutput(mappedString, filerDictionary(mappedString, DEFAULT_DICTIONARY));
        }
        List<String> compositeArr = new ArrayList<String>(Arrays.asList(customDictionary));
        for (int i = 0; i < DEFAULT_DICTIONARY.length; i++) {
            if(!compositeArr.contains(DEFAULT_DICTIONARY[i])) {
                compositeArr.add(DEFAULT_DICTIONARY[i]);
            }
        }

        String[] compositeDic = compositeArr.toArray(new String[compositeArr.size()]);
        return getAllPossibleOutput(mappedString, filerDictionary(mappedString, compositeDic));
    }

    private static String[] filerDictionary(String mappedString, String[] dictionary) {
        List<String> availableList = new ArrayList<String>();
        for (int i = 0; i < dictionary.length; i++) {
            if(mappedString.contains(dictionary[i].replaceAll(" ", ""))) {
                availableList.add(dictionary[i]);
            }
        }
        String[] availableDic = availableList.toArray(new String[availableList.size()]);
        return availableDic;
    }
}
