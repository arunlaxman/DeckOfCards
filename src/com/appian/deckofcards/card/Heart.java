/**
 * 
 */
package com.appian.deckofcards.card;

import com.appian.deckofcards.util.CardSuit;
import com.appian.deckofcards.util.CardValue;

/**
 * Card that belongs to suit Heart.
 *
 */
public class Heart extends Card {

	public Heart(CardValue value) {
		super(CardSuit.HEART, value);
	}
}
