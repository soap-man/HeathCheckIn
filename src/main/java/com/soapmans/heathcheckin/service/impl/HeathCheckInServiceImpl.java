package com.soapmans.heathcheckin.service.impl;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.mashape.unirest.http.exceptions.UnirestException;
import com.soapmans.heathcheckin.service.HeathCheckInService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Service
@Slf4j
public class HeathCheckInServiceImpl implements HeathCheckInService {

    private String heathUrl = System.getenv("HEATH_URL");
    private String requestParam = System.getenv("HEATH_BODY");

    @Override
    public String checkin() throws UnirestException {
        JSONObject heathCheckInParam = JSON.parseObject(requestParam);
        heathCheckInParam.put("h1011", LocalDate.now().minusDays(1).format(DateTimeFormatter.ofPattern("yyyy年MM月dd日")));
        log.info("heathCheckIn date: {}", LocalDate.now().minusDays(1));
        log.info("heathCheckIn param: {}", heathCheckInParam);
        Unirest.setTimeouts(0, 0);
        HttpResponse<String> result = Unirest.post(heathUrl)
                .header("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/101.0.4951.67 Safari/537.36")
                .header("Content-Type", "application/json")
                .body(JSON.toJSONString(heathCheckInParam))
                .asString();
        log.info("heathCheckIn result: {}", result.getBody());
        return result.getBody();
    }
}
