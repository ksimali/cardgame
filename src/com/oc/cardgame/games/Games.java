package com.oc.cardgame.games;

import com.oc.cardgame.controller.GameController;
import com.oc.cardgame.model.Deck;
import com.oc.cardgame.view.CommandLineView;
import com.oc.cardgame.view.GameSwingView;

public class Games {
	
	public static void main(String[] args) {
		GameSwingView gsv = new GameSwingView(); // instance de gameSwingView qu'on va passer en paramètre dans le controller
		gsv.createAndShowGUI();
		
		GameController gc = new GameController(new Deck(), gsv,  new HighCardGameEvaluator());
		
		//GameController gc = new GameController(new Deck(), new CommandLineView(),  new HighCardGameEvaluator());
		//GameController gc = new GameController(new Deck(), new View(),  new LowCardGameEvaluator());
		gc.run();
	}
}
