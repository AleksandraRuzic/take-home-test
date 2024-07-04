package com.incode.take_home_test.transformers;

import com.ibm.icu.text.Transliterator;
import com.incode.take_home_test.enums.TransformerType;

public class TransformerCyrillicGreek2Latin implements Transformer {

    public static final TransformerType TRANSFORMER_TYPE = TransformerType.CYRILLIC_GREEK_TO_LATIN;
    private static final Transliterator transliterator = Transliterator.createFromRules("Cyrillic-Latin-Extended",
                                                                                        "љ > lj;њ > nj;:: Cyrillic-Latin;",
                                                                                            Transliterator.FORWARD);

    @Override
    public String transform(String value) {
        return transliterator.transliterate(value);
    }
}
