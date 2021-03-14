package com.swia.iavd.model;

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

    @Override
    public CardType getCardType() {
        return null;
    }
}