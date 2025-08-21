package com.oc.cardgame.games;

import java.util.List;

import com.oc.cardgame.model.IPlayer;
import com.oc.cardgame.model.PlayingCard;

public interface GameEvaluator {
	public IPlayer evaluateWinner(List<IPlayer> players);
	
}
