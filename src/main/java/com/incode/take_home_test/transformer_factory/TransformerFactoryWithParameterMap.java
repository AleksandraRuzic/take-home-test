package com.incode.take_home_test.transformer_factory;

import com.incode.take_home_test.enums.TransformerType;
import com.incode.take_home_test.transformers.Transformer;
import com.incode.take_home_test.transformers.TransformerCyrillicGreek2Latin;
import com.incode.take_home_test.transformers.TransformerRegexRemove;
import com.incode.take_home_test.transformers.TransformerRegexReplace;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class TransformerFactoryWithParameterMap implements TransformerFactory {

    @Override
    public Transformer getTransformer(TransformerType transformerType, Map<String, String> params) {
        switch (transformerType) {
            case REGEX_REMOVE:
                String regex = params.get(TransformerRegexRemove.FIELD_NAME_REGEX_2_REMOVE);
                if (regex == null) {
                    throw new IllegalArgumentException(String.format("Required fields for transformer type %s are missing", TransformerType.REGEX_REMOVE));
                }
                return new TransformerRegexRemove(regex);
            case REGEX_REPLACE:
                String regex2find = params.get(TransformerRegexReplace.FIELD_NAME_REGEX_2_FIND);
                String replacement = params.get(TransformerRegexReplace.FIELD_NAME_REPLACEMENT);
                if (regex2find == null || replacement == null) {
                    throw new IllegalArgumentException(String.format("Required fields for transformer type %s are missing", TransformerType.REGEX_REPLACE));
                }
                return new TransformerRegexReplace(regex2find, replacement);
            case CYRILLIC_GREEK_TO_LATIN:
                return new TransformerCyrillicGreek2Latin();
            default:
                throw new IllegalArgumentException("Transformer type doesn't exist");
        }
    }
}
