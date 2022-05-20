package com.soapmans.heathcheckin.controller;

import com.mashape.unirest.http.exceptions.UnirestException;
import com.soapmans.heathcheckin.service.HeathCheckInService;
import com.soapmans.heathcheckin.vo.CheckInVo;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/heath")
public class HeathCheckInController {

    @Resource
    private HeathCheckInService heathCheckInService;

    @PostMapping("/checkin")
    public String checkin(@RequestBody CheckInVo checkInVo) throws UnirestException {
        return heathCheckInService.checkin(checkInVo);
    }

}
