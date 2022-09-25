package com.turgaydede.service;

import com.turgaydede.data.DummyData;
import com.turgaydede.model.RequestModel;

import java.util.Calendar;
import java.util.Date;

public class CheckRefreshToken extends Rule {
    public CheckRefreshToken() {
        nextRule = null;
    }

    @Override
    public boolean run(RequestModel requestModel) {
        switch (platform)
        {
            case Gsm:
            {
                if ((DummyData.tokenExpireDate.getTime() - requestModel.getTokenExpireDate().getTime()) / (1000 * 60) % 60 < 45)
                {
                    if (DummyData.refreshToken == requestModel.getRefreshToken())
                    {
                        DummyData.token = "167948364512";
                        DummyData.refreshToken = "73468317973648";
                        DummyData.tokenExpireDate = new Date(2022, 9, 22, 5, 50, 0);
                    }
                }
                break;
            }
            case Web:
            {
                Calendar calendar2 = Calendar.getInstance();
                calendar2.setTime(requestModel.getTokenExpireDate());

                Calendar calendar3 = Calendar.getInstance();
                calendar3.setTime(DummyData.tokenExpireDate);

                if ( (DummyData.tokenExpireDate.getTime() -  requestModel.getTokenExpireDate().getTime()) < 45)
                {
                    if (DummyData.refreshToken == requestModel.getRefreshToken())
                    {
                        DummyData.token = "12345678912";
                        DummyData.refreshToken = "98765432219842";
                        DummyData.tokenExpireDate = new Date(2022, 9, 22, 5, 50, 0);
                    }
                }
                break;
            }
            default:
            {
                break;
            }
        }
        return true;
    }
}
