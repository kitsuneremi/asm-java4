package repo;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import model.User;
import model.Video;

public class AdminUserRepo {
	public List<User> GetList() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("asmjava");
		EntityManager em = emf.createEntityManager();
		String hql = "select u from User u";
		try {
			em.getTransaction().begin();
			TypedQuery<User> query = em.createQuery(hql, User.class);
			List<User> list = query.getResultList();
			System.out.println(list.size());
			em.getTransaction().commit();
			em.close();
			return list;
		}catch(Exception ex){
			ex.printStackTrace();
			return null;
		}
	}
	
	public boolean Update(User v) {
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
		String hql = "select v from User v where v.id = '" + id + "'";
		try {
			em.getTransaction().begin();
			TypedQuery<User> query = em.createQuery(hql, User.class);
			User x = query.getSingleResult();
			em.remove(x);
			em.getTransaction().commit();
			em.close();
			return true;
		}catch(Exception ex){
			ex.printStackTrace();
			return false;
		}
	}
	
	public User findOne(String id) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("asmjava");
		EntityManager em = emf.createEntityManager();
		String hql = "select v from User v where v.id = '" + id + "'";
		try {
			em.getTransaction().begin();
			TypedQuery<User> query = em.createQuery(hql, User.class);
			User x = query.getSingleResult();
			em.getTransaction().commit();
			em.close();
			return x;
		}catch(Exception ex){
			ex.printStackTrace();
			return null;
		}
	}
}
