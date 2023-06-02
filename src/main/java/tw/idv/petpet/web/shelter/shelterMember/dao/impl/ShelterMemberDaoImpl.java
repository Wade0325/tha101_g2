package tw.idv.petpet.web.shelter.shelterMember.dao.impl;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;

import tw.idv.petpet.web.clinicMember.entity.ClinicMember;
import tw.idv.petpet.web.shelter.shelterMember.dao.ShelterMemberDao;
import tw.idv.petpet.web.shelter.shelterMember.entity.ShelterMember;

@Repository
public class ShelterMemberDaoImpl implements ShelterMemberDao{

	@Override
	public int insert(ShelterMember pojo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteById(Integer id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(ShelterMember pojo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public ShelterMember selectById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ShelterMember> selectAll() {
		// TODO Auto-generated method stub
		return null;
	}



}
