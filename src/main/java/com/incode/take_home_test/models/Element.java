package com.incode.take_home_test.models;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import jakarta.persistence.Entity;

import java.util.List;

@Entity
@JsonSerialize
public class Element {
    private String value;
    private String transformedValue;
    private List<TransformerObject> transformers;

    public String getValue() {
        return value;
    }

    public String getTransformedValue() {
        return transformedValue;
    }

    public List<TransformerObject> getTransformers() {
        return transformers;
    }

    public void setTransformedValue(String transformedValue) {
        this.transformedValue = transformedValue;
    }
}
