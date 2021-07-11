package com.mycompany.spktest;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class YoutubeTagsWordCount {
//    private static final String COMMA_DELIMITER = ",";
    public static void main(String[] args) throws IOException {
//
        List<Map.Entry> sortedTags = ReadFile.fileReader();
        for (Map.Entry<String, Long> entry : sortedTags) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }
    }}

