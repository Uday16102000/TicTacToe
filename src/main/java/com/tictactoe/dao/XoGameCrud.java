package com.tictactoe.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.tictactoe.entity.XoGame;


public class XoGameCrud {
	public EntityManager getManager()
	{
	EntityManager manager=Persistence.createEntityManagerFactory("uday").createEntityManager();
	return manager;
	}



	public void save(XoGame xoGame)
	{
		EntityManager manager=getManager();
		EntityTransaction t= manager.getTransaction();
		t.begin();
		manager.persist(xoGame);
		t.commit();
	}



	public  void saveGame(XoGame game) {
		EntityManager manager=getManager();
		EntityTransaction t= manager.getTransaction();
		t.begin();
		manager.persist(game);
		t.commit();		
	}
}
