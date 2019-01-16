package com.kyee.iot.common.util;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

import java.io.IOException;

/**
 * Description
 *
 * @author wangbingfu
 * @Date 2018/9/25
 */
public class CustomStringDeserializer extends JsonDeserializer<String> {
    @Override
    public String deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
        return jsonParser.getText();
    }

    @Override
    public String getNullValue(){
        return "";
    }
}
