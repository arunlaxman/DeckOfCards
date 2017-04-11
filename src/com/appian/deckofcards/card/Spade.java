/**
 * 
 */
package com.appian.deckofcards.card;

import com.appian.deckofcards.util.CardSuit;
import com.appian.deckofcards.util.CardValue;

/**
 * Card that belongs to suit Spade.
 *
 */
public class Spade extends Card {

	public Spade(CardValue value) {
		super(CardSuit.SPADE, value);
	}
}
