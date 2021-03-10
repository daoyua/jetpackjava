package com.example.network;

import java.lang.reflect.Type;

public interface Convert<T> {
    T convert(String response, Type type);
    T convert(String response, Class claz);
}
