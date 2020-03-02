package com.swia.iavd.model;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.swia.iavd.Utils;

import java.lang.reflect.Type;

public class CardMock extends Card {
    private int id;

    public CardMock(int id, String iavd) {
        super(iavd);
        this.id = id;
    }

    @Override
    public String getId() {
        return String.valueOf(id);
    }
}