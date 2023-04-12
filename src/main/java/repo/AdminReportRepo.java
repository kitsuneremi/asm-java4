package repo;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.Sender;
import model.User;
import model.Userfav;
import model.VideoSummary;

public class AdminReportRepo {
	public List<VideoSummary> One(){
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("asmjava");
		EntityManager em = emf.createEntityManager();
		String hql = "select new VideoSummary( v.title, count(f), min(f.likeDate), max(f.likeDate) ) from Video v join v.favourites f group by v.id";
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
	
	public List<Userfav> Two(String id){
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("asmjava");
		EntityManager em = emf.createEntityManager();
//		String hql = "select new Userfav( u.id, u.fullname, u.email, f.likeDate ) from Favourite f join Video.id f join User.id u where v.id = '" + id + "' group by v.id";
		String hql = "select new Userfav(u.id, u.fullname, u.email, f.likeDate) from User u join u.favourites f join f.video v where v.id = '" + id + "' group by v.id";
		try {
			em.getTransaction().begin();
			TypedQuery<Userfav> query = em.createQuery(hql, Userfav.class);
			List<Userfav> list = query.getResultList();
			em.getTransaction().commit();
			em.close();
			return list;
		}catch(Exception ex){
			ex.printStackTrace();
			return null;
		}
	}
	
	public List<Sender> Three(String id){
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("asmjava");
		EntityManager em = emf.createEntityManager();
		String hql = "select new Sender( u.fullname, u.email, s.email, s.shareDate ) from User u join u.shares s join s.video v where v.id = '" + id + "' group by v.id";
		try {
			em.getTransaction().begin();
			TypedQuery<Sender> query = em.createQuery(hql, Sender.class);
			List<Sender> list = query.getResultList();
			em.getTransaction().commit();
			em.close();
			return list;
		}catch(Exception ex){
			ex.printStackTrace();
			return null;
		}
	}
}
