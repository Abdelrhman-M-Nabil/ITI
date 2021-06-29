package com.company;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class DAO {
    private String cityPath;
    private String countryPath;
    List<City> CityL = new ArrayList<>();
    List<Country> CountryL = new ArrayList<>();
    List<Integer> L1 = new ArrayList<>();
    List<City> L2 = new ArrayList<>();
    Map<String, List<City>> mp = new HashMap<>();
    Map<String, List<City>> mp2 = new HashMap<>();


    public DAO(String cityPath, String countryPath) {
        this.cityPath = cityPath;
        this.countryPath = countryPath;
    }
     public City createCity(String[] Citydata )
     {
         int id = Integer.parseInt(Citydata[0]);
         String name = Citydata[1];
         int population = Integer.parseInt(Citydata[2]);
         String countryCode = Citydata[3];

         return new City(id,name,population, countryCode);
     }
     public Country createCountry(String[] Countrydata)
     {
         String code = Countrydata[0];
         String name = Countrydata[1];
         String continent = Countrydata[2];
         double surfaceArea = Double.parseDouble(Countrydata[3]);
         double population= Double.parseDouble(Countrydata[4]);
         double gnp = Double.parseDouble(Countrydata[5]);
         int capital = Integer.parseInt(Countrydata[6]);

         return new Country(code,name,continent,surfaceArea,population,gnp,capital);
     }
     public List<City> readCitiesFromCSV()throws Exception
     {
             //reading csv file of city
             BufferedReader br = new BufferedReader(new FileReader(cityPath));
             String line = br.readLine();
             //reading the file line by line
             while (line != null)
             {
                 String[] data = line.split(",");
                 City cit1 =createCity(data);
                 CityL.add(cit1);
                 line = br.readLine();
             }
             br.close();
         return CityL ;
     }
    public List<Country> readCountriesFromCSV()throws Exception
    {
            //fr = new FileReader(countryPath);
            BufferedReader br = new BufferedReader(new FileReader(countryPath));
            String line = br.readLine();
            //reading the file line by line
            while (line != null)
            {
                String[] countrydata = line.split(",");
                Country coun1 =createCountry(countrydata);
                CountryL.add(coun1);
                line = br.readLine();
            }
            br.close();
        return CountryL ;
    }
    public Map<String,List<City>> mapping(){
        //making a map of county code as keys and cities as a lists
        for(Country g1 : CountryL)
        {
            mp.put(g1.getCode(),CityL.stream()
                     .filter(c -> g1.getCode().trim().equals(c.getCountryCode().trim()) )
                     .collect(Collectors.toList()));

        }
        return mp;


    }
    public List<City> sortedPop(String a)
        {
            //sorting the map by highest population
            return mp.get(a).stream()
                     // use reversed to make the sorting descending
                     .sorted(Comparator.comparingDouble(City :: getPopulation).reversed())
                     .collect(Collectors.toList());
        }
    public List<Double> CPop()
    {
        //getting the populations and storing them in a list
        return CountryL.stream()
                       .map(c -> c.getPopulation())
                       .collect(Collectors.toList());
    }
    public Double CAVG()
    {
        // getting average population
        return CountryL.stream()
                       .mapToDouble(c -> c.getPopulation()).average().orElse(Double.NaN);
    }
    public Double CMax()
    {
        //returning the max population
        return CountryL.stream()
                       .mapToDouble(c -> c.getPopulation()).max().orElse(Double.NaN);
    }
    public Map<String,List<City>> HPopulationCity()
    {
        //getting the highest populated city for each country
        for (Country e:CountryL){
            mp2.put(e.getName(),mp.get(e.getCode()).stream()
                     .sorted(Comparator.comparingDouble(City :: getPopulation).reversed())
                     .limit(1)
                     .collect(Collectors.toList()));
            //used limit to take the most populated city in each country as they are sorted descendingly

    }
        return mp2;
    }
    public City HpopulationCap()
    {
        //getting the highest populated capital
        CountryL.stream()
                .forEach(c -> {L1.add(c.getCapital());});
        //getting every capital id and stores it in a list
        Collection<List<City>> val = mp2.values();
        val.stream()
                .flatMap(List::stream).forEach(x->{
                    if (L1.contains(x.getId()))
                    {
                        L2.add(x);
                    }
                //searching for the capital id in the most populated cities to return most populated capitals
        });
        return L2.stream()
                 .sorted(Comparator.comparingDouble(City :: getPopulation).reversed())
                 //sorting for the most populated capital on the first record
                 .findAny()
                 .get();

    }
}
