package repo;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import model.Favourite;
import model.Share;
import model.Video;

public class AdminVideo {
	public List<Video> GetListVideo() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("asmjava");
		EntityManager em = emf.createEntityManager();
		String hql = "select u from Video u";
		try {
			em.getTransaction().begin();
			TypedQuery<Video> query = em.createQuery(hql, Video.class);
			List<Video> list = query.getResultList();
			em.getTransaction().commit();
			em.close();
			return list;
		}catch(Exception ex){
			ex.printStackTrace();
			return null;
		}
	}
	
	public boolean Insert(Video v) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("asmjava");
		EntityManager em = emf.createEntityManager();
		try {
			em.getTransaction().begin();
			em.persist(v);
			em.getTransaction().commit();
			em.close();
			return true;
		}catch(Exception ex){
			ex.printStackTrace();
			return false;
		}
	}
	
	public boolean Update(Video v) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("asmjava");
		EntityManager em = emf.createEntityManager();
		try {
			em.getTransaction().begin();
			em.merge(v);
			em.getTransaction().commit();
			em.close();
			return true;
		}catch(Exception ex){
			ex.printStackTrace();
			return false;
		}
	}
	
	public boolean Delete(String id) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("asmjava");
		EntityManager em = emf.createEntityManager();
		String hql = "select v from Video v where v.id = '" + id + "'";
		try {
			em.getTransaction().begin();
			TypedQuery<Video> query = em.createQuery(hql, Video.class);
			Video x = query.getSingleResult();
			em.remove(x);
			em.getTransaction().commit();
			em.close();
			return true;
		}catch(Exception ex){
			ex.printStackTrace();
			return false;
		}
	}
	
	public Video findOne(String id) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("asmjava");
		EntityManager em = emf.createEntityManager();
		String hql = "select v from Video v where v.id = '" + id + "'";
		try {
			em.getTransaction().begin();
			TypedQuery<Video> query = em.createQuery(hql, Video.class);
			Video x = query.getSingleResult();
			em.getTransaction().commit();
			em.close();
			return x;
		}catch(Exception ex){
			ex.printStackTrace();
			return null;
		}
	}
}
