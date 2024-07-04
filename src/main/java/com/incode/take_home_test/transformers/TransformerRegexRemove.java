package com.incode.take_home_test.transformers;

import com.incode.take_home_test.enums.TransformerType;

public class TransformerRegexRemove implements Transformer {

    private final String regex2remove;

    public static final TransformerType TRANSFORMER_TYPE = TransformerType.REGEX_REMOVE;
    public static final String FIELD_NAME_REGEX_2_REMOVE = "regex2remove";

    public TransformerRegexRemove(String regex2remove) {
        this.regex2remove = regex2remove;
    }

    @Override
    public String transform(String value) {
        return value.replaceAll(regex2remove, "");
    }
}
