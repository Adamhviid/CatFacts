package com.example.demo.controllers;

import com.example.demo.services.CatService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;

@Controller
public class CatController {

    CatService service = new CatService();

    @GetMapping("/")
    @ResponseBody
    public String frontPage() {
        return "Front page for your cat facts!" + "<br>"
                + "'/getSingle' for a single cat fact" + "<br>"
                + "'/getTen' for ten random cat facts" + "<br>"
                + "'/getTenSorted' for ten random facts, sorted by date" + "<br>"
                + "'/sorted?character=x&amount=n' for a fact containing a specific number of a given char.";
    }

    @GetMapping("/getSingle")
    @ResponseBody
    public String singleFact() throws IOException {
        return service.singleFact();
    }

    @GetMapping("/getTen")
    @ResponseBody
    public String tenFacts() throws IOException{
        return service.tenFacts();
    }

    @GetMapping("/getTenSorted")
    @ResponseBody
    public String tenFactsSorted() throws IOException{
        return service.tenFactsSorted();

    }
    @GetMapping("/contains")
    @ResponseBody
    public String tryContains(@RequestParam char character, int amount) throws IOException {
        return service.factContains(character,amount);
    }
}
