/**
 * 
 */
package com.appian.deckofcards.factory;

import com.appian.deckofcards.card.Card;
import com.appian.deckofcards.card.Club;
import com.appian.deckofcards.util.CardValue;

/**
 * Factory for creating Club suit cards.
 *
 */
public class ClubFactory implements CardFactory {

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Card createCard(CardValue value) {
		return new Club(value);
	}
}
