package ru.belov.university.service.impl;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.json.JsonMapper;

import ru.belov.university.client.FeignGiphyClient;
import ru.belov.university.client.FeignOpenExchangeClient;
import ru.belov.university.model.ExchangeRate;
import ru.belov.university.service.RandomGifService;

@Service
public class RandomGifServiceImpl implements RandomGifService {

    @Value("${giphy.key}")
    private String apiKey;
    @Value("${openexchangerates.key}")
    private String appId;
    @Value("${giphy.tag.no-money}")
    private String tagNoMoney;
    @Value("${giphy.tag.rich}")
    private String tagRich;
    @Value("${giphy.tag.dont-worry}")
    private String tagDontWorry;

    @Autowired
    private FeignGiphyClient giphyClient;
    @Autowired
    private FeignOpenExchangeClient exchangeClient;

    @Override
    public ResponseEntity<Map<String, Object>> getRandomGif(String currency) {
        String tag = getGiphyTag(currency);
        return giphyClient.getRandom(apiKey, tag);
    }

    private String getGiphyTag(String currency) {
        Double yesterdayRate = getYesterdayRate(currency).getRates().get(currency);
        Double nowRate = getNowRate(currency).getRates().get(currency);

        if (yesterdayRate < nowRate) {
            return tagRich;
        } else if (yesterdayRate > nowRate) {
            return tagNoMoney;
        } else {
            return tagDontWorry;
        }
    }

    private ExchangeRate getYesterdayRate(String currency) {
        return compareJsonToExchangeRateOject(exchangeClient.getYesterdayRate(
                getYestardayDate(),
                appId,
                currency));
    }

    private ExchangeRate getNowRate(String currency) {
        return compareJsonToExchangeRateOject(exchangeClient.getRate(appId, currency));
    }

    private ExchangeRate compareJsonToExchangeRateOject(ResponseEntity<Object> object) {
        ObjectMapper mapper = JsonMapper
                .builder()
                .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)
                .build();

        String jsonString = null;
        ExchangeRate rate = null;
        try {
            jsonString = new ObjectMapper().writeValueAsString(object.getBody());
            rate = mapper.readValue(jsonString, ExchangeRate.class);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        } 

        return rate;
    }

    private String getYestardayDate() {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DATE, -1);
        return dateFormat.format(calendar.getTime());
    }
}
