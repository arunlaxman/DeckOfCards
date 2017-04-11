/**
 * 
 */
package com.appian.deckofcards.factory;

import com.appian.deckofcards.card.Card;
import com.appian.deckofcards.card.Spade;
import com.appian.deckofcards.util.CardValue;

/**
 * Factory for creating Spade suit cards.
 *
 */
public class SpadeFactory implements CardFactory {
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public Card createCard(CardValue value) {
		return new Spade(value);
	}

}
