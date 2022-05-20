package com.soapmans.heathcheckin.service;

import com.mashape.unirest.http.exceptions.UnirestException;

public interface HeathCheckInService {
    String checkin() throws UnirestException;
}
