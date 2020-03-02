package com.swia.iavd.model;

public abstract class Card {

    private final String iavd;

    protected Card(String iavd) {
        this.iavd = iavd;
    }

    /**
     * Get the ID of the card.
     *
     * @return A string representing the ID of the card.
     */
    public abstract String getId();

    /**
     * Get the card system of the card.
     *
     * @return The card system of the card.
     */
    public CardSystem getCardSystem() {
        String[] parts = iavd.split("/");
        return CardSystem.valueOf(parts[0].toUpperCase());
    }

    /**
     * Get the Vassal card ID of the card.
     *
     * @return The Vassal card ID of the card.
     */
    public int getVassalId() {
        String[] parts = iavd.split("/");
        return Integer.parseInt(parts[parts.length - 1]);
    }

    /**
     * Get the path to the IAVD file representing this card.
     *
     * @return The path to the IAVD file as a string.
     */
    public String getIavd() {
        return iavd;
    }

    @Override
    public int hashCode() {
        return getVassalId();
    }

    @Override
    public boolean equals(Object obj) {
        return obj instanceof Card && hashCode() == obj.hashCode();
    }
}
