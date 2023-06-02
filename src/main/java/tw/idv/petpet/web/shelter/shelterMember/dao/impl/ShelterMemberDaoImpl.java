package tw.idv.petpet.web.shelter.shelterMember.dao.impl;

import java.util.List;

import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import tw.idv.petpet.web.clinicMember.entity.ClinicMember;
import tw.idv.petpet.web.shelter.shelterMember.dao.ShelterMemberDao;
import tw.idv.petpet.web.shelter.shelterMember.entity.ShelterMember;

@Repository
public class ShelterMemberDaoImpl implements ShelterMemberDao{

	@PersistenceContext
	private Session session;
	

	@Override
	public int insert(ShelterMember shelterMember) {
		session.persist(shelterMember);
		return 1;
	}

	@Override
	public int deleteById(Integer shelterId) {
		ShelterMember shelterMember = session.load(ShelterMember.class, shelterId);
		return 1;
	}

	@Override
	public int update(ShelterMember shelterMember) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public ShelterMember selectById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ShelterMember> selectAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ShelterMember selectByShelterName(String shelterName) {
		CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
		CriteriaQuery<ShelterMember> criteriaQuery = criteriaBuilder.createQuery(ShelterMember.class);
		Root<ShelterMember> root = criteriaQuery.from(ShelterMember.class);
		criteriaQuery.where(criteriaBuilder.equal(root.get("shelterName"), shelterName));
		return session.createQuery(criteriaQuery).uniqueResult();
	}

	@Override
	public ShelterMember selectForLogin(String shelterEmail, String shelterPassword) {
		final String sql = "select * from sheltermember "
				+ "where shelterEmail = :shelterEmail and shelterPassword = :shelterPassword";
		return session.createNativeQuery(sql, ShelterMember.class)
				.setParameter("shelterEmail", shelterEmail)
				.setParameter("shelterPassword", shelterPassword)
				.uniqueResult();
	}
	

}
