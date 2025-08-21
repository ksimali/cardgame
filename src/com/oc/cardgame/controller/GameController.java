package com.oc.cardgame.controller;

import java.util.ArrayList;
import java.util.List;

import com.oc.cardgame.games.GameEvaluator;
import com.oc.cardgame.model.Deck;
import com.oc.cardgame.model.IPlayer;
import com.oc.cardgame.model.Player;
import com.oc.cardgame.model.PlayingCard;
import com.oc.cardgame.model.WinningPlayer;
import com.oc.cardgame.view.CommandLineView;
import com.oc.cardgame.view.GameViewable;


public class GameController {
	// attributes
	enum GameState {
		AddingPlayers, CardsDealt, WinnerRevealed;
	}
	Deck deck;
	List<IPlayer> players;
	IPlayer winner;
	GameViewable view;
	
	GameState gameState;
	
	// Add variable de classes
	GameEvaluator evaluator;
	
	// Constructor
	public GameController(Deck deck, GameViewable view, GameEvaluator evaluator) {
		super();
		this.deck = deck;
		this.view = view;
		this.players = new ArrayList<IPlayer>();
		this.gameState = GameState.AddingPlayers;
		view.setController(this);
		this.evaluator = evaluator;
		
	}
	
	// Methods --regarder l'etat du jeu et appel une methode de la vue
	public void run() {
		while(gameState == GameState.AddingPlayers) {
			view.promptForPlayerName();
		}
		
		switch (gameState) {
		case CardsDealt:
			view.promptForFlip();
			break;
		case WinnerRevealed:
			view.promptForNewGame();
			break;
		}
	}
	
	// Methode qui définit des joueurs
	public void addPlayer(String playerName) {
		if(gameState == GameState.AddingPlayers) {
			players.add(new Player(playerName));
			view.showPlayerName(players.size(), playerName);
		}
	}
	
	// Methode qui demarre le jeu(melange le deck, tirer une carte et passer à l'etape suivante)
	public void startGame() {
		if(gameState != GameState.CardsDealt) {
			deck.shuffle();
			int playerIndex = 1;
			for(IPlayer player : players) {
				player.addCardToHand(deck.removeTopCard());
				view.showFaceDownCardForPlayer(playerIndex++, player.getName());
			}
			gameState = GameState.CardsDealt;
		}
		this.run(); // passer à l'etape suivante du jeu
	}
	
	// Method pour montrer les cartes et afficher le gagnant
	public void flipCards() {
		int playerIndex = 1;
		for(IPlayer player : players) {
			PlayingCard pc = player.getCard(0);
			pc.flip();
			view.showCardForPlayer(playerIndex++, player.getName(),
					pc.getRank().toString(), pc.getSuit().toString());
		}
		
		evaluateWinner();
		displayWinner();
		rebuildDeck();
		gameState = GameState.WinnerRevealed;
		this.run();
	}
	
	// method evaluateWinner()
	void evaluateWinner() {
		winner = new WinningPlayer(evaluator.evaluateWinner(players));
	}
	// method displayWinner() qui affiche le nom du gagnant
	void displayWinner() {
		view.showWinner(winner.getName());
	}
	// Method rebuildDeck(): récupérer toutes les cartes distribuée et les remets dans le jeu.
	void rebuildDeck() {
		for(IPlayer player : players) {
			deck.returnCardToDeck(player.removeCard());
		}
	}
	
	// Method exit pour quitter le jeux
	void exitGame() {
		System.exit(0);
	}

	public void nextAction(String nextChoice) {
		
		if("+q".equals(nextChoice)) {
			exitGame();
		}else {
			startGame();
		}
		
	}

}
