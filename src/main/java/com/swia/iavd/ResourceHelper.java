package com.swia.iavd;

import com.swia.iavd.model.CardSystem;
import com.swia.iavd.model.CardType;

import java.io.IOException;
import java.io.InputStream;

public class ResourceHelper {

    public static InputStream getResource(String path) throws IOException {
        try {
            return ResourceHelper.class.getClassLoader().getResourceAsStream(path);
        } catch (NullPointerException e) {
            throw new IOException(path);
        }
    }

    public static String getResourceContent(String path) throws IOException {
        try {
            InputStream stream = getResource(path);
            String content = Utils.readAll(stream);
            stream.close();
            return content;
        } catch (NullPointerException e) {
            throw new IOException(path);
        }
    }

    public static InputStream getResource(CardSystem cardSystem, CardType cardType) throws IOException {
        String path = cardSystem.toString().toLowerCase() + "_" + cardType.toString().toLowerCase() + "_dataset.json";
        return getResource(path);
    }

    public static String getResourceContent(CardSystem cardSystem, CardType cardType) throws IOException {
        InputStream stream = getResource(cardSystem, cardType);
        String content = Utils.readAll(stream);
        stream.close();
        return content;
    }

}
