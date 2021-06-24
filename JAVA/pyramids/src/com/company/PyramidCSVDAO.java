package com.company;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.List;

public class PyramidCSVDAO {
    private String path;
    List<Pyramids> L1 = new ArrayList<Pyramids>();

    public PyramidCSVDAO(String path) {
        this.path = path;
    }

    public Pyramids createPyramid(String[] data) {
        String pharoah = data[0];
        String modern_name = data[2];
        String site = data[4];
        double height;
        if (data[7] == null || data[7].length() == 0) {
            height = 0;
        } else {
            height = Double.parseDouble(data[7]);
        }
        return new Pyramids(pharoah, modern_name, site, height);
    }

    public List<Pyramids> readPyramidsFromCSV() {

        try {
            FileReader fr = new FileReader(path);
            BufferedReader br = new BufferedReader(fr);
            String head = br.readLine();
            String line = br.readLine();
            while (line != null) {
                String[] data = line.split(",");
                Pyramids p1 = createPyramid(data);
                L1.add(p1);
                line = br.readLine();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return L1;

    }

    private class ComparePyramidsHeights implements Comparator<Pyramids> {
        @Override
        public int compare(Pyramids p1, Pyramids p2)
        {
            return Double.compare(p1.getHeight(), p2.getHeight());
        }


    }
    public void sort()
    {
        Collections.sort(L1, new ComparePyramidsHeights());
    }
    public Map<String,Integer> mapping(){
        Map<String, Integer> mp = new HashMap<>();
        for(Pyramids p : L1)
        {
            if(!mp.containsKey(p.getSite())){
                mp.put(p.getSite(),1);
            }
            else{
                mp.put(p.getSite(), mp.get(p.getSite()) + 1);
            }
        }
        return mp;
    }

}

