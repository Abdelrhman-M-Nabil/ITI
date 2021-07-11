package com.mycompany.spktest;

import java.util.List;
import java.util.Map;
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

public class ReadFile<puplic> {

    private static final String COMMA_DELIMITER = "," ;
    public static List<Map.Entry> fileReader() throws IOException{
        Logger.getLogger ("org").setLevel (Level.ERROR);
        // CREATE SPARK CONTEXT
        SparkConf conf = new SparkConf ().setAppName ("wordCounts").setMaster ("local[3]");
        JavaSparkContext sparkContext = new JavaSparkContext (conf);
        // LOAD DATASETS
        JavaRDD<String> videos = sparkContext.textFile ("D:\\AI\\1-Technical\\09-Java&UML\\Day6\\USvideos.csv");



        // TRANSFORMATIONS
        JavaRDD<String> titles = videos
                .map (ReadFile::extractTags)
                .filter (StringUtils::isNotBlank);
        // JavaRDD<String>
        JavaRDD<String> words = titles.flatMap (title -> Arrays.asList (title
                .toLowerCase ()
                .trim ()
                .replaceAll("\\p{Punct}","")
                .split (" ")).iterator ());
        System.out.println(words.toString ());
        // COUNTING
        Map<String, Long> wordCounts = words.countByValue ();
        List<Map.Entry> sorted = wordCounts.entrySet ().stream ()
                .sorted (Map.Entry.comparingByValue ()).collect (Collectors.toList ());

        return sorted;
    }
    public static String extractTags(String videoLine) {
        try {
            return videoLine.split (COMMA_DELIMITER)[2];
        } catch (ArrayIndexOutOfBoundsException e) {
            return "";
        }

    }
}
