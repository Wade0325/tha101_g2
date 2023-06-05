package tw.idv.petpet.web.clinic.petCases.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tw.idv.petpet.web.clinic.petCases.entity.PetCase;

@Repository
public interface PetCaseRepository extends JpaRepository<PetCase, Integer> {
    // 可以在这里定义自定义的查询方法或使用默认的查询方法
}
