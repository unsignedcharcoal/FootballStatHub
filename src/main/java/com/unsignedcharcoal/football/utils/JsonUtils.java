package com.unsignedcharcoal.football.utils;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.TypeFactory;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class JsonUtils {

    private static final ObjectMapper mapper;

    static {
        mapper = new ObjectMapper();
        mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
    }

    public static <T> T parseClass(String text, Class<T> valueType) {
        try {
            return mapper.readValue(text, valueType);
        } catch (Exception e) {
            throw new ParseClassException(valueType, e.getMessage());
        }
    }

    public static <T> List<T> parseList(String text, Class<T> valueType) {
        try {
            return mapper.readValue(text, TypeFactory.defaultInstance().constructCollectionType(List.class, valueType));
        } catch (Exception e) {
            throw new ParseClassException(valueType, e.getMessage());
        }
    }

    public static String writeClass(Class<?> valueType) {
        try {
            return mapper.writeValueAsString(valueType);
        } catch (Exception e) {
            throw new WriteClassException(valueType, e.getMessage());
        }
    }

    protected static class ParseClassException extends RuntimeException {

        public ParseClassException(@NotNull Class<?> clazz, String exMessage) {
            super("Could not parse class: " + clazz.getName() + " from JSON text \n" + exMessage);
        }

    }

    protected static class WriteClassException extends RuntimeException {

        public WriteClassException(@NotNull Class<?> clazz, String exMessage) {
            super("Could not write class: " + clazz.getName() + " to JSON text \n" + exMessage);
        }

    }
}
