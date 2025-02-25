package com.oc.cardgame.model;

import java.util.ArrayList;

public class TestDeck extends Deck {
	// Constructor -- on créer juste les 32 cartes par combinaison de Rank et Suit
		public TestDeck() {
			cards = new ArrayList<PlayingCard>();
			for(int i = 0; i < 20; ++i) {
				cards.add(new PlayingCard (Rank.ACE, Suit.CLUBS));
			}
		}
}
