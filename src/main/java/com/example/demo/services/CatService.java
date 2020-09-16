package com.example.demo.services;

import com.example.demo.models.CatModel;
import com.google.gson.Gson;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;

public class CatService {

    public String singleFact() throws IOException {

        URL catURL = new URL("https://cat-fact.herokuapp.com/facts/random");
        BufferedReader catURLinput = new BufferedReader(new InputStreamReader(catURL.openStream()));
        CatModel catData = new Gson().fromJson(catURLinput, CatModel.class);
        catURLinput.close();

        return catData.toString();
    }

    public String tenFacts() throws IOException {

        ArrayList<CatModel> factList = new ArrayList<>(10);

        for (int i = 1; i <= 10; i++) {
            URL catURL = new URL("https://cat-fact.herokuapp.com/facts/random");
            BufferedReader catURLinput = new BufferedReader(new InputStreamReader(catURL.openStream()));
            CatModel catData = new Gson().fromJson(catURLinput, CatModel.class);

            factList.add(catData);

            catURLinput.close();

        }
        return factList.toString();
    }

    public static String tenFactsSorted() throws IOException {

        ArrayList<CatModel> factList = new ArrayList<>(10);

        for (int i = 1; i <= 10; i++) {
            URL catURL = new URL("https://cat-fact.herokuapp.com/facts/random");
            BufferedReader catURLinput = new BufferedReader(new InputStreamReader(catURL.openStream()));
            CatModel catData = new Gson().fromJson(catURLinput, CatModel.class);
            catURLinput.close();

            factList.add(catData);
        }
        Collections.sort(factList);
        return factList.toString();
    }

    public String factContains(char c, int n) throws IOException {
        URL catURL = new URL("https://cat-fact.herokuapp.com/facts/random");
        BufferedReader catURLinput = new BufferedReader(new InputStreamReader(catURL.openStream()));
        CatModel catData = new Gson().fromJson(catURLinput, CatModel.class);
        catURLinput.close();

        int charCount = 0;

        for (int i = 0; i < catData.getText().length(); i++) {
            if (catData.getText().charAt(i) == c) {
                charCount++;
            }
        }
        if (charCount == n) {
            return catData.toString();
        }
        return "No cat fact containing the character '" + c + "', " + n + " number of times." + "<br>" + "Please try again";
    }
}
