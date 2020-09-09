package com.example.demo.services;

import com.example.demo.models.CatModel;
import com.google.gson.Gson;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

public class CatService {

    public String serviceCat() throws IOException {

        URL catURL = new URL("https://cat-fact.herokuapp.com/facts/random");

        BufferedReader catURLinput = new BufferedReader(new InputStreamReader(catURL.openStream()));

        CatModel catData = new Gson().fromJson(catURLinput, CatModel.class);

        catURLinput.close();

        return catData.toString();
    }

    @Override
    public String toString() {
        try {
            return serviceCat();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "hov";
    }
}
