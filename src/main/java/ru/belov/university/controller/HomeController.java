package ru.belov.university.controller;

import java.util.Arrays;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import ru.belov.university.enums.Сurrency;

@Controller
@RequestMapping("/giphy-app")
public class HomeController {

    @GetMapping("/")
    public String getHomePage() {
        return "home";
    }

    @GetMapping("/get-gif")
    public String getRandomGif(Model model) {
        model.addAttribute("currencies", Arrays.asList(Сurrency.values()));
        return "random-gif";
    }
}
