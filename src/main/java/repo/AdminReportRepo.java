package repo;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.User;
import model.VideoSummary;

public class AdminReportRepo {
	public List<VideoSummary> One(){
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("asmjava");
		EntityManager em = emf.createEntityManager();
		String hql = "select new VideoSummary( v.title, count(v.favourites), min(f.likeDate), max(f.likeDate) ) from Video v join v.favourites f group by v.id";
		try {
			em.getTransaction().begin();
			TypedQuery<VideoSummary> query = em.createQuery(hql, VideoSummary.class);
			List<VideoSummary> list = query.getResultList();
			em.getTransaction().commit();
			em.close();
			return list;
		}catch(Exception ex){
			ex.printStackTrace();
			return null;
		}
	}
}