//package tw.idv.petpet.web.shelter.shelterMember.dao.impl;
//
//import java.util.List;
//
//import javax.persistence.PersistenceContext;
//import javax.persistence.criteria.CriteriaBuilder;
//import javax.persistence.criteria.CriteriaQuery;
//import javax.persistence.criteria.Root;
//
//import org.hibernate.Session;
//import org.springframework.stereotype.Repository;
//
//import tw.idv.petpet.web.clinicMember.entity.ClinicMember;
//import tw.idv.petpet.web.shelter.shelterAnimal.dao.ShelterAnimalDao;
//import tw.idv.petpet.web.shelter.shelterAnimal.entity.ShelterAnimal;
//import tw.idv.petpet.web.shelter.shelterMember.dao.ShelterMemberDao;
//import tw.idv.petpet.web.shelter.shelterMember.entity.ShelterMember;
//
//@Repository
//public class ShelterMemberDaoImpl implements ShelterMemberDao{
//
//	@Override
//	public int insert(ShelterMember pojo) {
//		// TODO Auto-generated method stub
//		return 0;
//	}
//
//	@Override
//	public int deleteById(Integer id) {
//		// TODO Auto-generated method stub
//		return 0;
//	}
//
//	@Override
//	public int update(ShelterMember pojo) {
//		// TODO Auto-generated method stub
//		return 0;
//	}
//
//	@Override
//	public ShelterMember selectById(Integer id) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public List<ShelterMember> selectAll() {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public ClinicMember selectByClinicName(String clinicName) {
//		CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
//		CriteriaQuery<ClinicMember> criteriaQuery = criteriaBuilder.createQuery(ClinicMember.class);
//		Root<ClinicMember> root = criteriaQuery.from(ClinicMember.class);
//		criteriaQuery.where(criteriaBuilder.equal(root.get("clinicName"), clinicName));
//		return session.createQuery(criteriaQuery).uniqueResult();
//	}
//
//	@Override
////	public ClinicMember selectForLogin(String clinicEmail, String clinicPassword) {
//		final String sql = "select * from clinicmember "
//				+ "where clinicEmail = :clinicEmail and clinicPassword = :clinicPassword";
//		return session.createNativeQuery(sql, ClinicMember.class)
//				.setParameter("clinicEmail", clinicEmail)
//				.setParameter("clinicPassword", clinicPassword)
//				.uniqueResult();
////	}
//	
//
//}
