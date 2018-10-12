package pl.akademiakodu.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

import pl.akademiakodu.demo.models.StartModel;

@Controller
public class StartController {

    @GetMapping("/")
    public String startpage(Model model){
        return "startpage";
    }

    @PostMapping("/")
    public String startpage(@RequestParam("city") String city, Model model){

        String link = "http://api.openweathermap.org/data/2.5/weather?q=" + city +
                    "&appid=3ffe628f6a24e1ba57eb593eca3419bb";

        RestTemplate restTemplate = new RestTemplate();
        StartModel startModel = restTemplate.getForObject(link, StartModel.class);

        model.addAttribute("speed", startModel.getWind().getSpeed());

        return "startpage";
    }

}
