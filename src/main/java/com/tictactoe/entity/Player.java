package com.tictactoe.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Entity
public class Player {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int playerId;
	private String name;
	private char symbol;
	private int wins;
    private int losses;
    private int draws;

//    private int uniqueId;
//	public int getUniqueId() {
//	return uniqueId;
//}

public int getWins() {
		return wins;
	}

	public void setWins(int wins) {
		this.wins = wins;
	}

	public int getLosses() {
		return losses;
	}

	public void setLosses(int losses) {
		this.losses = losses;
	}

	public int getDraws() {
		return draws;
	}

	public void setDraws(int draws) {
		this.draws = draws;
	}

public Player(String name, char symbol) {
		super();
		this.name = name;
		this.symbol = symbol;
//		this.uniqueId = uniqueId;
	}

//public void setUniqueId(int uniqueId) {
//	this.uniqueId = uniqueId;
//}

	public int getPlayerId() {
	return playerId;
}

public void setPlayerId(int playerId) {
	this.playerId = playerId;
}

	public char getSymbol() {
		return symbol;
	}

	public void setSymbol(char symbol) {
		this.symbol = symbol;
	}

	public String getName() {
		return name;
	}

	public void setName(String p1Name) {
		this.name = p1Name;
	}


	public Player() {
		super();
	}


	

	
	
}
