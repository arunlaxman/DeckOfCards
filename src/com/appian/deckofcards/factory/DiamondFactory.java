/**
 * 
 */
package com.appian.deckofcards.factory;

import com.appian.deckofcards.card.Card;
import com.appian.deckofcards.card.Diamond;
import com.appian.deckofcards.util.CardValue;

/**
 * Factory for creating Diamond suit cards.
 *
 */
public class DiamondFactory implements CardFactory {
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public Card createCard(CardValue value) {
		return new Diamond(value);
	}

}
