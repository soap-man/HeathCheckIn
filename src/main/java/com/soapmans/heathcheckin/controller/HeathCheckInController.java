package com.soapmans.heathcheckin.controller;

import com.mashape.unirest.http.exceptions.UnirestException;
import com.soapmans.heathcheckin.service.HeathCheckInService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/heath")
public class HeathCheckInController {

    @Resource
    private HeathCheckInService heathCheckInService;

    @RequestMapping("/checkin")
    public String checkin() throws UnirestException {
        return heathCheckInService.checkin();
    }

}
