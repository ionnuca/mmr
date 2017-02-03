package personal.home.MMR.DAO;

import org.hibernate.Session;

import personal.home.MMR.Utilities.HibernateUtil;
import personal.home.MMR.entities.User;

public class UserDao {

	public User insertUser(User user) {
		Session session = HibernateUtil.getSession().openSession();

		user.setId(null);
		session.beginTransaction();
		session.persist(user);
		session.getTransaction().commit();

		session.close();
		return user;
	}

}
