package tw.idv.petpet.web.clinicMember.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import tw.idv.petpet.web.clinicMember.dao.PriceListDao;
import tw.idv.petpet.web.clinicMember.entity.PriceList;

@Repository
@Transactional
public class PriceListDaoImpl implements PriceListDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void create(PriceList priceList) {
        entityManager.persist(priceList);
    }

    @Override
    public PriceList getById(int clinicServiceId) {
        return entityManager.find(PriceList.class, clinicServiceId);
    }

    @Override
    public void update(PriceList priceList) {
        entityManager.merge(priceList);
    }

    @Override
    public void delete(PriceList priceList) {
        entityManager.remove(priceList);
    }

	@Override
	public List<PriceList> getAllPriceLists() {
		// TODO Auto-generated method stub
		return null;
	}


}
