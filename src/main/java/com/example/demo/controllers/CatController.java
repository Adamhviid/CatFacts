package com.example.demo.controllers;

import com.example.demo.models.CatModel;
import com.example.demo.services.CatService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringJoiner;

@Controller
public class CatController {

    CatModel model = new CatModel();
    CatService service = new CatService();
    ArrayList<String> FactList = new ArrayList<>(10);

    @GetMapping("/")
    @ResponseBody
    public String frontPage(){
        return "Front page for your cat facts!";
    }

    @GetMapping("/getSingle")
    @ResponseBody
    public String singleFact() {

        return service.toString();
    }

    @GetMapping("/getTen")
    @ResponseBody
    public String tenFacts() {

        for ( int i = 1; i <= 10; i++) {
            FactList.add(service.toString());
        }
        return FactList.toString();
    }
    @GetMapping("/getTenSortByDate")
    @ResponseBody
    public String tenFactsSorted() {

        for ( int i = 1; i <= 10; i++) {
            FactList.add(service.toString());
        }
        Collections.sort(FactList);
        return Arrays.toString(FactList.toArray());

    }

}
