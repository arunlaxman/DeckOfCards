/**
 * 
 */
package com.appian.deckofcards.factory;

import com.appian.deckofcards.card.Card;
import com.appian.deckofcards.card.Heart;
import com.appian.deckofcards.util.CardValue;

/**
 * Factory for creating Heart suit cards.
 *
 */
public class HeartFactory implements CardFactory {
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public Card createCard(CardValue value) {
		return new Heart(value);
	}

}
