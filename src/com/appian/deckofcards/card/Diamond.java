package com.appian.deckofcards.card;

import com.appian.deckofcards.util.CardSuit;
import com.appian.deckofcards.util.CardValue;

/**
 * Card that belongs to suit Diamond.
 *
 */
public class Diamond extends Card {
	
	public Diamond(CardValue value) {
		super(CardSuit.DIAMOND, value);
	}

}
