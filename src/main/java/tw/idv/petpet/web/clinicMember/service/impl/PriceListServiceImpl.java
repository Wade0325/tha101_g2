package tw.idv.petpet.web.clinicMember.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tw.idv.petpet.web.clinicMember.dao.PriceListDao;

import tw.idv.petpet.web.clinicMember.entity.PriceList;
import tw.idv.petpet.web.clinicMember.service.PriceListService;

@Service
public class PriceListServiceImpl implements PriceListService {

    private final PriceListDao priceListDAO;

    @Autowired
    public PriceListServiceImpl(PriceListDao priceListDAO) {
        this.priceListDAO = priceListDAO;
    }

    @Override
    public void createPriceList(PriceList priceList) {
        priceListDAO.create(priceList);
    }

    @Override
    public PriceList getPriceListById(int clinicServiceId) {
        return priceListDAO.getById(clinicServiceId);
    }

    @Override
    public void updatePriceList(PriceList priceList) {
        priceListDAO.update(priceList);
    }

    @Override
    public void deletePriceList(int clinicServiceId) {
        PriceList priceList = priceListDAO.getById(clinicServiceId);
        if (priceList != null) {
            priceListDAO.delete(priceList);
        }
    }

    @Override
    public List<PriceList> getAllPriceLists() {
        return priceListDAO.getAllPriceLists();
    }

    // 其他查询或操作方法...

}
