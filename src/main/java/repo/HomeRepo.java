package repo;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.User;
import model.Video;

public class HomeRepo {
	public List<Video> GetListVideo() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("asmjava");
		EntityManager em = emf.createEntityManager();
		String hql = "select u from Video u";
		try {
			em.getTransaction().begin();
			TypedQuery<Video> query = em.createQuery(hql, Video.class);
			List<Video> list = query.getResultList();
			System.out.println(list.size());
			em.getTransaction().commit();
			em.close();
			return list;
		}catch(Exception ex){
			ex.printStackTrace();
			return null;
		}
	}
}
