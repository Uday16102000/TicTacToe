package com.tictactoe.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.tictactoe.entity.Player;



public class PlayerCrud {
	    	public EntityManager getManager() {
		EntityManager manager=Persistence.createEntityManagerFactory("uday").createEntityManager();
		return manager;
		}



		public void save(Player player)
		{
			EntityManager manager=getManager();
			EntityTransaction t= manager.getTransaction();
			t.begin();
			manager.persist(player);
			t.commit();
		}
		public Player fetchPlayerById(int id)
		{
			EntityManager m=getManager();
			Player p=m.find(Player.class, id);
			if(p!=null)
			{
				System.out.println(p + "already exist");
			}
			return p;
		}



		public void updateWin(int playerId) {
			EntityManager m=getManager();
			Player p=m.find(Player.class, playerId);
			p.setWins(p.getWins()+1);
			EntityTransaction  t= m.getTransaction();
			t.begin();
			m.merge(p);
			t.commit();
			 

			
			
			
		}



		public void updateLoss(int playerId) {
			EntityManager m=getManager();
			Player p=m.find(Player.class, playerId);
			p.setLosses(p.getLosses()+1);
			EntityTransaction  t= m.getTransaction();
			t.begin();
			m.merge(p);
			t.commit();
			 			
		}



		public void updateDraw(int playerId) {
			
			EntityManager m=getManager();
			Player p=m.find(Player.class, playerId);
			p.setDraws(p.getLosses()+1);
			EntityTransaction  t= m.getTransaction();
			t.begin();
			m.merge(p);
			t.commit();
			 
		}



	

}
