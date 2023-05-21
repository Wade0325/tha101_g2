package tw.idv.petpet.web.user.dao.Impl;

import java.util.List;

import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;


import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import tw.idv.petpet.web.user.dao.UserDao;
import tw.idv.petpet.web.user.entity.User;
@Repository
public class UserDaoImpl implements UserDao {
	@PersistenceContext
	private Session session;

	@Override
	public int insert(User user) {
		session.persist(user);
		return 1;
	}

	@Override
	public int deleteById(Integer id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(User pojo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public User selectById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<User> selectAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User selectByAccount(String useraccount) {
		CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
		CriteriaQuery<User> criteriaQuery = criteriaBuilder.createQuery(User.class);
		Root<User> root = criteriaQuery.from(User.class);
		criteriaQuery.where(criteriaBuilder.equal(root.get("username"), useraccount));
		return session.createQuery(criteriaQuery).uniqueResult();
	}

	@Override
	public User selectForLogin(String useraccount, String userpassword) {
		// TODO Auto-generated method stub
		return null;
	}

}
