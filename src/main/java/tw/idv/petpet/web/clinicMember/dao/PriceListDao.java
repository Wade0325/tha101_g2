package tw.idv.petpet.web.clinicMember.dao;


import java.util.List;

import tw.idv.petpet.web.clinicMember.entity.PriceList;

public interface PriceListDao {

    void create(PriceList priceList);

    PriceList getById(int clinicServiceId);

    void update(PriceList priceList);

    void delete(PriceList priceList);

	List<PriceList> getAllPriceLists();



    // 其他查询或操作方法...

}
