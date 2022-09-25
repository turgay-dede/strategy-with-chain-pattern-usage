package com.turgaydede;

import com.turgaydede.data.DummyData;
import com.turgaydede.model.RequestModel;
import com.turgaydede.service.CheckPlatformRule;
import com.turgaydede.service.Rule;

import java.util.Calendar;

public class Main {
    public static void main(String[] args) {
        RequestModel model = new RequestModel();
        model.setIMEI("111222333444555");
        model.setRefreshToken("98349785389732");
        model.setUserId(1);
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(DummyData.tokenExpireDate);
        calendar.add(Calendar.HOUR_OF_DAY, 1);
        model.setTokenExpireDate(calendar.getTime());

        Rule firstRule = new CheckPlatformRule();
        while (firstRule.nextRule != null)
        {
            if ((firstRule).run(model))
            {
                firstRule = firstRule.nextRule;
            }
            else
            {
                System.out.println("Unauthorized 401!");
                break;
            }
        }
        //Working Tail Rule Process
        if (firstRule.nextRule == null)
        {
            if (firstRule.run(model))
            {
                System.out.println("Authorized 200 OK!");
            }
            else
            {
                System.out.println("Unauthorized 401!");            }
        }

        System.out.println("Token: " + DummyData.token);
        System.out.println("RefreshToken: " + DummyData.refreshToken);
        System.out.println("Token Expire Date: " + DummyData.tokenExpireDate);
    }
}
