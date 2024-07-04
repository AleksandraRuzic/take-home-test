package com.incode.take_home_test.controllers;

import com.incode.take_home_test.annotations.TransformElements;
import com.incode.take_home_test.models.Element;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ElementsController {

    @PostMapping("/elements")
    @TransformElements()
    public List<Element> transformElements(@RequestBody List<Element> elements) {
        return elements;
    }
}
