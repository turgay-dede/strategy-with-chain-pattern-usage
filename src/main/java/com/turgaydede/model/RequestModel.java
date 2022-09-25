package com.turgaydede.model;

import lombok.Data;

import java.util.Date;

@Data
public class RequestModel {
    public int userId;
    public String IMEI;
    public String token;
    public String refreshToken;
    public Date tokenExpireDate;
}
