package tw.idv.petpet.web.shelter.shelterAnimal.dao.Impl;

import java.util.List;

import javax.persistence.PersistenceContext;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import tw.idv.petpet.web.member.entity.Member;
import tw.idv.petpet.web.shelter.shelterAnimal.dao.ShelterAnimalDao;
import tw.idv.petpet.web.shelter.shelterAnimal.entity.ShelterAnimal;

@Repository
public class ShelterAnimalDaoImpl implements ShelterAnimalDao {
	@PersistenceContext
	private Session session;

	@Override
	public int insert(ShelterAnimal ShelterAnimal) {
		session.persist(ShelterAnimal);
		return 1;
	}

	@Override
	public int deleteById(Integer animalId) {
		ShelterAnimal ShelterAnimal = session.load(ShelterAnimal.class, animalId);
		session.remove(ShelterAnimal);
		return 1;
	}

	@Override
	public int update(ShelterAnimal pojo) {
		// TODO Auto-generated method stub
		return 0;
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

}
