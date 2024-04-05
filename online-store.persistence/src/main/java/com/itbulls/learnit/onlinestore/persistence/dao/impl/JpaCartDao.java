package com.itbulls.learnit.onlinestore.persistence.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.itbulls.learnit.onlinestore.persistence.dao.CartDao;
import com.itbulls.learnit.onlinestore.persistence.dto.CartDto;

@Repository
public class JpaCartDao implements CartDao {

	@Override
	public void saveCart(CartDto cart) {
		EntityManagerFactory emf = null;
		EntityManager em = null;
		try {
			emf = Persistence.createEntityManagerFactory("persistence-unit");
			em = emf.createEntityManager();
			em.getTransaction().begin();

			em.persist(cart);

			em.getTransaction().commit();
		} finally {
			if (emf != null) {
				emf.close();
			}
			if (em != null) {
				em.close();
			}
		}
	}


	@Override
	public List<CartDto> getProductsFromCartByUserId(int userId) {
		EntityManagerFactory emf = null;
		EntityManager em = null;
		try {
			emf = Persistence.createEntityManagerFactory("persistence-unit");
			em = emf.createEntityManager();
			em.getTransaction().begin();
			TypedQuery<CartDto> query = em.createQuery("SELECT c FROM cart c WHERE c.userDto.id = :id",
					CartDto.class);
			query.setParameter("id", userId);
			List<CartDto> resultList = query.getResultList();
			em.getTransaction().commit();
			return resultList;
		} finally {
			if (emf != null) {
				emf.close();
			}
			if (em != null) {
				em.close();
			}
		}
	}



	@Override
	public void deleteCartProductsByUserId(int userId) {
	    EntityManagerFactory emf = null;
	    EntityManager em = null;
	    try {
	        emf = Persistence.createEntityManagerFactory("persistence-unit");
	        em = emf.createEntityManager();
	        em.getTransaction().begin();
	        Query query = em.createQuery("DELETE FROM cart c WHERE c.userDto.id = :id");
	        query.setParameter("id", userId);
	        int rowsAffected = query.executeUpdate();
	        em.getTransaction().commit();
	    } finally {
	        if (emf != null) {
	            emf.close();
	        }
	        if (em != null) {
	            em.close();
	        }
	    }
	}




}
