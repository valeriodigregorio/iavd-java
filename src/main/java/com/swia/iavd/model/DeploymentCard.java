package com.swia.iavd.model;

public class DeploymentCard extends Card {

	private final String name;
	private final String affiliation;
	private final boolean unique;
	private final boolean elite;
	private final String description;
	
	/**
	 * Create a deployment card.
	 * @param affiliation The affiliation of the card.
	 * @param name The name of the card.
	 * @param unique True if the card is unique. Otherwise false.
	 * @param elite True if the card is elite. Otherwise false.
	 * @param description The description of the card.
	 * @param iavd The path to the IAVD file representing the card.
	 */
	public DeploymentCard(String affiliation, String name, boolean unique, boolean elite, String description, String iavd) {
		super(iavd);
		this.affiliation = affiliation;
		this.name = name;
		this.unique = unique;
		this.elite = elite;
		this.description = description;
	}

	/**
	 * Get the ID of a card.
	 * @param affiliation The affiliation of the card.
	 * @param name The name of the card.
	 * @param unique True if the card is unique. Otherwise false.
	 * @param elite True if the card is elite. Otherwise false.
	 * @param description The description of the card.
	 * @return A string representing the ID of the card.
	 */
	public static String getId(String affiliation, String name, boolean unique, boolean elite, String description) {
		StringBuilder builder = new StringBuilder();
		builder.append(affiliation).append(" - ").append(name);
		if (unique) {
			builder.append(", ").append(description);
		} else {
			builder.append(" (").append(elite ? "Elite" : "Regular").append(")");
		}
		return builder.toString();
	}

	/**
	 * Get the ID of the card.
	 * @return A string representing the ID of the card.
	 */
	@Override
	public String getId() {
		return DeploymentCard.getId(affiliation, name, unique, elite, description);
	}

	/**
	 * Get the affiliation of the card.
	 * @return The affiliation of the card.
	 */
	public String getAffiliation() {
		return affiliation;
	}

	/**
	 * Get the name of the card.
	 * @return The name of the card.
	 */
	public String getName() {
		return name;
	}

	/**
	 * Check whether the card is unique.
	 * @return True if the card is unique. Otherwise false.
	 */
	public boolean isUnique() {
		return unique;
	}

	/**
	 * Check whether the card is elite.
	 * @return True if the card is elite. Otherwise false.
	 */
	public boolean isElite() {
		return elite;
	}

	/**
	 * Get the description of the card.
	 * @return The description of the card.
	 */
	public String getDescription() {
		return description;
	}
}
