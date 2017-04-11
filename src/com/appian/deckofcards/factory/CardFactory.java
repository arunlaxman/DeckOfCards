package com.appian.deckofcards.factory;

import com.appian.deckofcards.card.Card;
import com.appian.deckofcards.util.CardValue;

/**
 * This interface represents the parent factory for all the suit factories in Abstract Factory design pattern.
 *
 */
public interface CardFactory {

	/**
	 * Creates a card for a suit and value.
	 * 
	 * @param value the face value of the card.
	 * @return the instance of the Card.
	 */
	public Card createCard(CardValue value);
}
