package tw.idv.petpet.web.clinicMember.service;



import java.util.List;

import tw.idv.petpet.web.clinicMember.entity.PriceList;

public interface PriceListService {

	void createPriceList(PriceList priceList);

    PriceList getPriceListById(int clinicServiceId);

    void updatePriceList(PriceList priceList);

    void deletePriceList(int clinicServiceId);

    List<PriceList> getAllPriceLists();

}
