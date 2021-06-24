package com.company;

import java.util.List;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        PyramidCSVDAO PDAO = new PyramidCSVDAO("D:\\AI\\1-Technical\\09-Java&UML\\pyramids.csv");
        List<Pyramids> listOfPyramids = PDAO.readPyramidsFromCSV();
        PDAO.sort();
        // pirnt all pyramids

        int i = 0;
        for (Pyramids p : listOfPyramids)
            System.out.println("#" + i++ + p);
        // create the map
        Map siteCount = PDAO.mapping();
        System.out.println(siteCount);
    }
}
