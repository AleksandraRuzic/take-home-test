package com.incode.take_home_test.transformers;

import com.incode.take_home_test.enums.TransformerType;

public class TransformerRegexReplace implements Transformer {
    private final String regex2find;
    private final String replacement;

    public static final String FIELD_NAME_REGEX_2_FIND = "regex2find";
    public static final String FIELD_NAME_REPLACEMENT = "replacement";
    public static final TransformerType TRANSFORMER_TYPE = TransformerType.REGEX_REPLACE;

    public TransformerRegexReplace(String regex2find, String replacement) {
        this.regex2find = regex2find;
        this.replacement = replacement;
    }

    @Override
    public String transform(String value) {
        return value.replaceAll(regex2find, replacement);
    }
}
