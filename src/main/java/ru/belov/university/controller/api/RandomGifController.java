package ru.belov.university.controller.api;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ru.belov.university.service.impl.RandomGifServiceImpl;

@RestController
@RequestMapping("giphy-app/api")
public class RandomGifController {

    @Autowired
    RandomGifServiceImpl rateService;

    @GetMapping("/random-gif")
    public ResponseEntity<Map<String, Object>> getRandomGif(
            @RequestParam(value = "currency") String currency) {
        return rateService.getRandomGif(currency);
    }
}
