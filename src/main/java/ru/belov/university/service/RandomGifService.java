package ru.belov.university.service;

import java.util.Map;

import org.springframework.http.ResponseEntity;

public interface RandomGifService {

    ResponseEntity<Map<String, Object>> getRandomGif(String currency);

}
