package repo;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.Video;

public class DetailRepo {
	public Video GetVideo(String id) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("asmjava");
		EntityManager em = emf.createEntityManager();
		String hql = "select u from Video u where u.id = '" + id + "'";
		try {
			em.getTransaction().begin();
			TypedQuery<Video> query = em.createQuery(hql, Video.class);
			Video list = query.getSingleResult();
			em.getTransaction().commit();
			em.close();
			return list;
		}catch(Exception ex){
			ex.printStackTrace();
			return null;
		}
	}
}
