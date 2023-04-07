package repo;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;

import model.User;


public class LoginRepo {
	public boolean Login(String username, String password) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("asmjava");
		EntityManager em = emf.createEntityManager();
		String hql = "select u from User u where id = '" + username + "' and password = '" + password +"'";
		try {
			em.getTransaction().begin();
			TypedQuery<User> query = em.createQuery(hql, User.class);
			List<User> list = query.getResultList();
			em.getTransaction().commit();
			em.close();
			System.out.println(list);
			if(list.size() > 0) {
				return true;
			}else {
				return false;
			}
		}catch(Exception ex){
			ex.printStackTrace();
			return false;
		}
	}
}
