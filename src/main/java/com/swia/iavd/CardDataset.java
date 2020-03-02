package com.swia.iavd;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import com.swia.iavd.model.Card;
import com.swia.iavd.model.CardSystem;
import com.swia.iavd.model.CardType;

public class CardDataset {
	
	private final Map<String, Card> stringToCard = new HashMap<>();
	private final Map<Integer, Card> intToCard = new HashMap<>();

	/**
	 * Create a card dataset for a specific card system.
	 * @param cardSystem The card system.
	 * @throws IOException Exception thrown if an error occurred reading the dataset.
	 */
	public CardDataset(CardSystem cardSystem) throws IOException {
		addCards(CardType.DEPLOYMENT.getDataset(CardSystem.FFG));
		addCards(CardType.COMMAND.getDataset(CardSystem.FFG));
		if (cardSystem != CardSystem.FFG) {
			addCards(CardType.DEPLOYMENT.getDataset(cardSystem));
			addCards(CardType.COMMAND.getDataset(cardSystem));
		}
	}

	/**
	 * Create a card dataset for a specific set of cards.
	 * @param cards An array of cards.
	 */
	public CardDataset(Card[] cards) {
		addCards(cards);
	}

	private void addCards(Card[] cards) {
		for (Card card : cards) {
			stringToCard.put(card.getId(), card);
			intToCard.put(card.getVassalId(), card);
		}
	}

	/**
	 * Retrieve a card by ID.
	 * @param id The string ID representing the card.
	 * @return The class representing the requested card.
	 */
	public Card getCard(String id) {
		return stringToCard.get(id);
	}

	/**
	 * Retrieve a card by Vassal card ID.
	 * @param id The Vassal card ID.
	 * @return The class representing the requested card.
	 */
	public Card getCard(int id) {
		return intToCard.get(id);
	}
	
}
