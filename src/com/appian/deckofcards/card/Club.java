/**
 * 
 */
package com.appian.deckofcards.card;

import com.appian.deckofcards.util.CardSuit;
import com.appian.deckofcards.util.CardValue;

/**
 * Card that belongs to suit Club.
 *
 */
public class Club extends Card {
	
	public Club(CardValue value) {
		super(CardSuit.CLUB, value);
	}

}
