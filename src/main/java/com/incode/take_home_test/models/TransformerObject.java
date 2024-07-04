package com.incode.take_home_test.models;

import com.incode.take_home_test.enums.TransformerType;

import java.util.Map;

public class TransformerObject {
    private final TransformerType transformerType;
    private final Map<String, String> params;

    public TransformerObject(TransformerType transformerType, Map<String, String> params) {
        this.transformerType = transformerType;
        this.params = params;
    }

    public TransformerType getTransformerType() {
        return transformerType;
    }

    public Map<String, String> getParams() {
        return params;
    }
}
