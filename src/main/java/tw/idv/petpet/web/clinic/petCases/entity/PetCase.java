package tw.idv.petpet.web.clinic.petCases.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
@Setter
@Getter
@AllArgsConstructor
@Entity
@Table(name = "pet_case")
public class PetCase {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cases_sn")
    private Integer casesSn;

    @Column(name = "vet_sn")
    private Integer vetSn;

    @Column(name = "user_id")
    private Integer userId;

    @Temporal(TemporalType.DATE)
    @Column(name = "appoint_date")
    private Date appointDate;

    @Column(name = "owner_mobile", length = 10)
    private String ownerMobile;

    @Column(name = "pet_type", length = 45)
    private String petType;

    @Column(name = "pet_name", length = 45)
    private String petName;

    @Column(name = "pet_gender", length = 45)
    private String petGender;

    @Column(name = "pet_age")
    private Integer petAge;

    @Column(name = "pet_situation", length = 200)
    private String petSituation;

    @Column(name = "treatment", length = 200)
    private String treatment;

    @Column(name = "result", length = 45)
    private String result;

    public PetCase() {
        // 默认构造函数
    }

    // 构造函数、Getter和Setter方法省略（可自动生成）
}
