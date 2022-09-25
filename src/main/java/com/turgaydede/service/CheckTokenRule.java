package com.turgaydede.service;

import com.turgaydede.data.DummyData;
import com.turgaydede.enums.Platform;
import com.turgaydede.model.RequestModel;

public class CheckTokenRule extends Rule {
    public CheckTokenRule() {
        nextRule = new CheckTokenExpireRule();
    }

    @Override
    public boolean run(RequestModel requestModel) {
        switch (platform)
        {
            case Gsm:
            {
                nextRule.platform = Platform.Gsm;
                return requestModel.getUserId() == DummyData.userID &&
                        (requestModel.getToken() == DummyData.token || requestModel.getRefreshToken() == DummyData.refreshToken);
            }
            case Web:
            {
                nextRule.platform = Platform.Web;
                return requestModel.getUserId()==DummyData.userID && requestModel.getToken() == DummyData.token;
            }
            default:
            {
                return false;
            }
        }
    }
}
