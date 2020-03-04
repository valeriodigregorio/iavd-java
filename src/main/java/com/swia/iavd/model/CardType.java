package com.swia.iavd.model;

import com.google.gson.Gson;
import com.swia.iavd.ResourceHelper;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public enum CardType {
    DEPLOYMENT(DeploymentCard[].class),
    COMMAND(CommandCard[].class);

    private final Class<? extends Card[]> cls;

    CardType(Class<? extends Card[]> cls) {
        this.cls = cls;
    }

    public Card[] getDataset(CardSystem cardSystem) throws IOException {
        InputStream stream = ResourceHelper.getResource(cardSystem, this);
        InputStreamReader reader = new InputStreamReader(stream);
        Gson gson = new Gson();
        return gson.fromJson(reader, this.cls);
    }
}
