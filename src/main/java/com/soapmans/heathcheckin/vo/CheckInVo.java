package com.soapmans.heathcheckin.vo;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CheckInVo {
    private String url;
    private String body;
}
