package com.oc.cardgame.model;

import java.util.ArrayList;

public class NormalDeck extends Deck {
	
	// Constructor -- on créer les les 52 cartes par combinaison de Rank et Suit
	public NormalDeck() {
		cards = new ArrayList<PlayingCard>();
		for(Rank rank : Rank.values()) {
			for(Suit suit : Suit.values()) {
				System.out.println("Creating card ["+rank+"]["+suit+"]");
				cards.add(new PlayingCard(rank, suit));
			}
		}
		shuffle(); // On mélange les cartes
	}
}
