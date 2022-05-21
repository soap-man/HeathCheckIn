package com.soapmans.heathcheckin.service.impl;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.mashape.unirest.http.exceptions.UnirestException;
import com.soapmans.heathcheckin.service.HeathCheckInService;
import com.soapmans.heathcheckin.vo.CheckInVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Service
@Slf4j
public class HeathCheckInServiceImpl implements HeathCheckInService {

    @Override
    public String checkin(CheckInVo checkInVo) throws UnirestException {
        JSONObject heathCheckInParam = JSON.parseObject(checkInVo.getBody());
        heathCheckInParam.getJSONObject("questionContent").put("h1011", LocalDate.now().minusDays(1).format(DateTimeFormatter.ofPattern("yyyy年MM月dd日")));
        log.info("heathCheckIn date: {}", LocalDate.now().minusDays(1));
        HttpResponse<String> result = Unirest.post(checkInVo.getUrl())
                .header("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/101.0.4951.67 Safari/537.36")
                .header("Content-Type", "application/json")
                .body(JSON.toJSONString(heathCheckInParam))
                .asString();
        return result.getBody();
    }
}
