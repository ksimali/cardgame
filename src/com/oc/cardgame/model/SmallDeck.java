package com.oc.cardgame.model;

import java.util.ArrayList;

public class SmallDeck extends Deck{
	// Constructor -- on créer juste les 32 cartes par combinaison de Rank et Suit
	public SmallDeck() {
		cards = new ArrayList<PlayingCard>();
		for(Rank rank : Rank.values()) {
			for(Suit suit : Suit.values()) {
				if(rank.value() >= 7) {
					System.out.println();
					cards.add(new PlayingCard(rank, suit));
				}		
			}
		}
		shuffle(); // On mélange les cartes
	}
}
