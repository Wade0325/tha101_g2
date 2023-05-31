package tw.idv.petpet.web.shelter.shelterAnimal.dao.Impl;

import java.util.List;

import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.criterion.CriteriaQuery;
import org.springframework.stereotype.Repository;

import tw.idv.petpet.web.shelter.shelterAnimal.dao.ShelterAnimalDao;
import tw.idv.petpet.web.shelter.shelterAnimal.entity.ShelterAnimal;

@Repository
public class ShelterAnimalDaoImpl implements ShelterAnimalDao {
	@PersistenceContext
	private Session session;

	@Override
	public int insert(ShelterAnimal ShelterAnimal) {
		session.merge(ShelterAnimal);
		return 1;
	}

	@Override
	public int deleteById(Integer animalId) {
		ShelterAnimal ShelterAnimal = session.load(ShelterAnimal.class, animalId);
		session.remove(ShelterAnimal);
		return 1;
	}

	@Override
	public int update(ShelterAnimal shelteranimal) {
		return 1;
	}

	@Override
	public ShelterAnimal selectById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ShelterAnimal> selectAll() {
		final String hql = "FROM ShelterAnimal ORDER BY animalId";
		return session
				.createQuery(hql, ShelterAnimal.class)
				.getResultList();
	}

	@Override
	public ShelterAnimal selectForUpload(Integer animalId) {
		CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
		javax.persistence.criteria.CriteriaQuery<ShelterAnimal> criteriaQuery = criteriaBuilder.createQuery(ShelterAnimal.class);
		Root<ShelterAnimal> root = criteriaQuery.from(ShelterAnimal.class);
		criteriaQuery.where(criteriaBuilder.equal(root.get("animalId"), animalId));
		return session.createQuery(criteriaQuery).uniqueResult();
	}

}
