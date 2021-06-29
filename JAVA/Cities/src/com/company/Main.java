package com.company;

import java.util.*;

public class Main {

    public static void main(String[] args)throws Exception {
        DAO CDAO = new DAO("D:\\AI\\1-Technical\\09-Java&UML\\Day4\\Data_sets\\Cities.csv"
                          ,"D:\\AI\\1-Technical\\09-Java&UML\\Day4\\Data_sets\\Countries.csv");

        //the two lists a list of cities and one for countries if u need to check them un comment the folloing lines


        List<City> L1 = new ArrayList<>();
        List<Country> L2 = new ArrayList<>();
        L1 = CDAO.readCitiesFromCSV();
        L2 = CDAO.readCountriesFromCSV();
        /*
        System.out.println(L1);
        System.out.println(L2);
        */

        //getting the needed map with key = Country code and val a list of cities
        Map<String, List<City>> maps = new HashMap<>();
        maps = CDAO.mapping();
        System.out.println(maps.size());
        maps.forEach((k, v) -> System.out.println("key="+ k+ ", value="+ v));

        //reading a country code and searching for its cities sorted descendingly by population
        System.out.println("Enter the country Code you want");
        Scanner sc= new Scanner(System.in);
        String fullstring =  sc.nextLine();

        List<City> L3 = new ArrayList<>();
        L3 =CDAO.sortedPop(fullstring);
        System.out.println("the country you searched for "+L3);

        //getting countries population
        List<Double> l4 = new ArrayList<>();
        l4 = CDAO.CPop();
        System.out.println("Countries populations "+l4);

        //Average country population
        double a = CDAO.CAVG();
        System.out.println("Average countries population is "+a);

        //Max country population
        double b = CDAO.CMax();
        System.out.println("Max Population "+b);

        //most populated city in each country
        Map<String, List<City>> Hpop = new HashMap<>();
        Hpop = CDAO.HPopulationCity();
        Hpop.forEach((k, v) -> System.out.println("key="+ k+ ", value="+ v));

        //most populated capital
        City cap = CDAO.HpopulationCap();
        System.out.println("The most populated capital is "+cap);

    }
}
