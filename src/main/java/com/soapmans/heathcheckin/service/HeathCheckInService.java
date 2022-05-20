package com.soapmans.heathcheckin.service;

import com.mashape.unirest.http.exceptions.UnirestException;
import com.soapmans.heathcheckin.vo.CheckInVo;

public interface HeathCheckInService {
    String checkin(CheckInVo checkInVo) throws UnirestException;
}
