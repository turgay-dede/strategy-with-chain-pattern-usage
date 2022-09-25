package com.turgaydede.service;

import com.turgaydede.enums.Platform;
import com.turgaydede.model.RequestModel;

public class CheckPlatformRule extends Rule{

    public CheckPlatformRule() {
        this.nextRule = new CheckTokenRule();
    }

    @Override
    public boolean run(RequestModel requestModel) {
        if ("".equals(requestModel.getIMEI()) || requestModel.getIMEI() == null)
        {
            nextRule.platform = Platform.Web;
            return "".equals(requestModel.getToken()) && requestModel.getToken() != null;
        }
        else if (!"".equals(requestModel.getIMEI()) && requestModel.getIMEI() != null)
        {
            nextRule.platform = Platform.Gsm;
            return (!"".equals(requestModel.getToken()) && requestModel.getToken() != null) || (!"".equals(requestModel.getRefreshToken()) && requestModel.getRefreshToken() != null);
        }
        return false;
    }
}
