package com.turgaydede.service;

import com.turgaydede.enums.Platform;
import com.turgaydede.model.RequestModel;

public abstract class Rule {
    public Rule nextRule;
    Platform platform;
    public abstract boolean run(RequestModel requestModel);
}
