package tw.idv.petpet.web.clinicMember.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
@ToString
@Getter
@Setter
@AllArgsConstructor
@Entity
@Table(name = "price_list")
public class PriceList {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "clinic_service_id")
    private int clinicServiceId;
    
    @Column(name = "clinic_service_name")
    private String clinicServiceName;
    
    @Column(name = "service_price")
    private int servicePrice;
    
    @Column(name = "service_discount_price")
    private int serviceDiscountPrice;
    
    @Column(name = "service_item1")
    private String serviceItem1;
    
    @Column(name = "service_item2")
    private String serviceItem2;
    
    @Column(name = "service_item3")
    private String serviceItem3;
    
    @Column(name = "service_item4")
    private String serviceItem4;
    
    @Lob
    @Column(name = "service_img", columnDefinition = "longblob")
    private byte[] serviceImg;
    public PriceList() {
        // 空的构造函数
    }
	

    // getters and setters

    // Add any additional methods, constructors, and annotations as needed
}
