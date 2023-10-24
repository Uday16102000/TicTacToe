package com.tictactoe.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;


@Entity
public class XoGame {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private int gameId;

@ManyToOne
private Player player1;
@ManyToOne
private Player player2;

@OneToOne( cascade = CascadeType.ALL)
private GameLog gameLogs;

public int getGameId() {
	return gameId;
}
public void setGameId(int gameId) {
	this.gameId = gameId;
}



 
public GameLog getGameLogs() {
	return gameLogs;
}
public void setGameLogs(GameLog gameLogs) {
	this.gameLogs = gameLogs;
}
public XoGame(Player player1, Player player2, GameLog gameLogs) {
	super();
	this.player1 = player1;
	this.player2 = player2;
	this.gameLogs = gameLogs;
}
public XoGame(int gameId, Player player1, Player player2) {
	super();
	this.gameId = gameId;
	this.player1 = player1;
	this.player2 = player2;
}
public Player getPlayer1() {
	return player1;
}
public void setPlayer1(Player player1) {
	this.player1 = player1;
}
public Player getPlayer2() {
	return player2;
}
public void setPlayer2(Player player2) {
	this.player2 = player2;
}

public XoGame() {
	super();
}
public XoGame(Player player1, Player player2) {
	super();
	this.player1 = player1;
	this.player2 = player2;
}




}
