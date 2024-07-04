package com.incode.take_home_test.aspects;

import com.incode.take_home_test.annotations.TransformElements;
import com.incode.take_home_test.models.Element;
import com.incode.take_home_test.transformer_factory.TransformerFactory;
import com.incode.take_home_test.transformer_factory.TransformerFactoryWithParameterMap;
import com.incode.take_home_test.transformers.Transformer;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.stream.Collectors;

@Aspect
@Component
public class TransformElementsAspect {

    private static final TransformerFactory transformerFactory = new TransformerFactoryWithParameterMap();

    @Around("@annotation(transformElements) && args(@RequestBody requestBody, ..)")
    public Object transformElements(ProceedingJoinPoint joinPoint, TransformElements transformElements, List<Element> requestBody) throws Throwable {
        if(transformElements.isDisabled()) {
            return joinPoint.proceed();
        }

        try {
            return requestBody.stream().map(this::transformValue).collect(Collectors.toList());
        } catch (IllegalArgumentException ex) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST, ex.getMessage(), ex);
        }
    }

    private Element transformValue(Element element) {
        String value = element.getValue();
        List<Transformer> transformers = element.getTransformers().stream()
                    .map(x -> transformerFactory.getTransformer(x.getTransformerType(), x.getParams()))
                    .collect(Collectors.toList());

        String result = transformers.stream().reduce(value, (valueToTransform, transformer) -> transformer.transform(valueToTransform), (a, b) -> b);

        element.setTransformedValue(result);
        return element;
    }
}