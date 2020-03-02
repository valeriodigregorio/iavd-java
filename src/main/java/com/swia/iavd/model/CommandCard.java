package com.swia.iavd.model;

public class CommandCard extends Card {

	private final String name;
	
	/**
	 * Create a command card.
	 * @param name The name of the card.
	 * @param iavd The path to the IAVD file representing the card.
	 */
	public CommandCard(String name, String iavd) {
		super(iavd);
		this.name = name;
	}

	/**
	 * Get the ID of the card.
	 * @param name The name of the card.
	 * @return A string representing the ID of the card.
	 */
	public static String getId(String name) {
		return name;
	}

	/**
	 * Get the ID of a card.
	 * @return A string representing the ID of the card.
	 */
	@Override
	public String getId() {
		return CommandCard.getId(name);
	}

	/**
	 * Get the name of the card.
	 * @return The name of the card.
	 */
	public String getName() {
		return name;
	}
}
