package com.incode.take_home_test.transformer_factory;

import com.incode.take_home_test.enums.TransformerType;
import com.incode.take_home_test.transformers.Transformer;

import java.util.Map;

public interface TransformerFactory {
    Transformer getTransformer(TransformerType transformerType, Map<String, String> params);
}
