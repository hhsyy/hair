package com.it.haircut.utils;

import lombok.Data;
import java.util.HashMap;
@Data
public class Result<T> {

    private int code;

    private Object msg;

    private HashMap<String, T> res;
}