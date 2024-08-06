package com.abelalvarz.ordershipment.converters;


import com.abelalvarz.ordershipment.dtos.response.Response;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import javax.xml.transform.Source;

@Component
public class ResponseConverter implements Converter<Object, Response> {
    @Override
    public Response convert(Object source) {
        return Response.builder()
                .data(source)
                .message("Success operation.")
                .statusCode(200)
                .success(true)
                .build();
    }
}
