package com.turgaydede.service;

import com.turgaydede.data.DummyData;
import com.turgaydede.enums.Platform;
import com.turgaydede.model.RequestModel;

import java.util.Calendar;

public class CheckTokenExpireRule extends Rule {
    public CheckTokenExpireRule() {
        nextRule = new CheckRefreshToken();
    }

    @Override
    public boolean run(RequestModel requestModel) {
        switch (platform)
        {
            case Gsm:
            {
                nextRule.platform = Platform.Gsm;
                Calendar calendar = Calendar.getInstance();
                calendar.setTime(DummyData.tokenExpireDate);
                calendar.add(Calendar.HOUR_OF_DAY, 2);
                if (requestModel.getTokenExpireDate().before(calendar.getTime()))
                {
                    return true;
                }
                return false;
            }
            case Web:
            {
                nextRule.platform = Platform.Web;
                if (requestModel.getTokenExpireDate().before(DummyData.tokenExpireDate))
                {
                    return true;
                }
                return false;
            }
            default:
            {
                return false;

            }
        }
    }
}
