package org.jtesttools.mockit;

import static okhttp3.FormBody.Builder;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonConverter {

    public static final String EMPTY_JSON = "{}";
    private static final Logger log = LoggerFactory.getLogger(JsonConverter.class);
    private static ObjectMapper mapper;

    public JsonConverter() {
        mapper = new ObjectMapper();
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
    }

    protected JsonConverter(ObjectMapper mapper) {
        this.mapper = mapper;
    }

    public static JsonConverter of() {
        return new JsonConverter();
    }

    public String toString(Object value) {
        try {
            return mapper.writeValueAsString(value);
        } catch (JsonProcessingException e) {
            log.error("Error on parser to JSON: " + e.getMessage(), e);
            return EMPTY_JSON;
        }
    }

    public <T> T toObject(String json, Class<T> clazz) {
        try {
            return mapper.readValue(json, clazz);
        } catch (IOException e) {
            log.error(e.getMessage(), e);
            return null;
        }
    }

    public Builder buildFormBody(String json) {
        Map<String, String> values = toObject(json, HashMap.class);
        Builder body = new Builder();
        for (String key : values.keySet()) {
            body.add(key, values.get(key));
        }
        return body;
    }

}
