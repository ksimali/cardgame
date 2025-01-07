package com.oc.cardgame.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Deck {
	// attributes
	private List<PlayingCard> cards;
	
	// Getter
	public List<PlayingCard> getCards(){
		return cards;
	}
	
	// Constructor -- on créer les les 52 cartes par combinaison de Rank et Suit
	public Deck() {
		cards = new ArrayList<PlayingCard>();
		for(Rank rank : Rank.values()) {
			for(Suit suit : Suit.values()) {
				System.out.println();
				cards.add(new PlayingCard(rank, suit));
			}
		}
		shuffle(); // On mélange les cartes
	}
	
	// method pour mélanger les cartes
	public void shuffle() {
		Random random = new Random();
		for (int i=0; i < cards.size(); ++i) {
			Collections.swap(cards, i, random.nextInt(cards.size()));
		}
	}
	
	// methodes pour tirer la carte du deck et remettre la carte dans le deck
	public PlayingCard removeTopCard() {
		return cards.remove(0);
	}
	
	public void returnCardToDeck(PlayingCard pc) {
		cards.add(pc);
	}
}
