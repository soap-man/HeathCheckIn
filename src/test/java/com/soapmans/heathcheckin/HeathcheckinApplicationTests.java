package com.soapmans.heathcheckin;

import com.mashape.unirest.http.exceptions.UnirestException;
import com.soapmans.heathcheckin.service.HeathCheckInService;
import com.soapmans.heathcheckin.vo.CheckInVo;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
class HeathcheckinApplicationTests {


    @Resource
    HeathCheckInService heathCheckInService;

    @Test
    void contextLoads() throws UnirestException {
        CheckInVo checkInVo = CheckInVo.builder()
                .url(System.getProperty("HEATH_URL"))
                .body(System.getProperty("HEATH_BODY"))
                .build();
        System.out.println(checkInVo);
        heathCheckInService.checkin(checkInVo);
    }

}
