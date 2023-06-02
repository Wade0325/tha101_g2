package tw.idv.petpet.web.shelter.shelterMember.service.impl;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tw.idv.petpet.web.shelter.Repository.ShelterMemberRepo;
import tw.idv.petpet.web.shelter.shelterMember.dao.ShelterMemberDao;
import tw.idv.petpet.web.shelter.shelterMember.entity.ShelterMember;
import tw.idv.petpet.web.shelter.shelterMember.service.ShelterMemberService;

@Service
public class ShelterMemberServiceImpl implements ShelterMemberService{
	@Autowired
	private ShelterMemberDao dao;
	@Autowired
	private ShelterMemberRepo repo;
	@Transactional
	public ShelterMember register(ShelterMember shelterMember) {
//		if (shelterMember.getShelterName() == null) {
//			shelterMember.setMessage("名稱未輸入");
//			shelterMember.setSuccessful(false);
//			return shelterMember;
//		}
//		if (shelterMember.getShelterPrincipal() == null) {
//			shelterMember.setMessage("負責人未輸入");
//			shelterMember.setSuccessful(false);
//			return shelterMember;
//		}
//		if (shelterMember.getShelterEmail() == null) {
//			shelterMember.setMessage("信箱未輸入");
//			shelterMember.setSuccessful(false);
//			return shelterMember;
//		}
////		if (dao.selectByShelterName(shelterMember.getShelterName()) != null) {
////			shelterMember.setMessage("名稱重複");
////			shelterMember.setSuccessful(false);
////			return shelterMember;
////		}
//		if (shelterMember.getShelterPassword() == null) {
//			shelterMember.setMessage("密碼未輸入");
//			shelterMember.setSuccessful(false);
//			return shelterMember;
//		}
//		if (shelterMember.getShelterPhone() == null) {
//			shelterMember.setMessage("電話未輸入");
//			shelterMember.setSuccessful(false);
//			return shelterMember;
//		}
//		if (shelterMember.getShelterAddress() == null) {
//			shelterMember.setMessage("地址未輸入");
//			shelterMember.setSuccessful(false);
//			return shelterMember;
//		}
//		final int id = dao.insert(shelterMember);
//		if (id < 1) {
//			shelterMember.setMessage("註冊有誤，請聯絡管理員!");
//			shelterMember.setSuccessful(false);
//			return shelterMember;
//		}
//		
//		shelterMember.setMessage("註冊成功");
//		shelterMember.setSuccessful(true);
		
		return shelterMember;
}

	@Override
	public List<ShelterMember> findAll() {
		return dao.selectAll();
	}
	
	@Transactional
	@Override
	public boolean remove(Integer animalId) {
		repo.deleteById(animalId);
		return true;
	}

	@Override
	public boolean save(ShelterMember shelterMemberMember) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public ShelterMember edit(ShelterMember shelterMemberMember) {
		// TODO Auto-generated method stub
		return null;
	}

	
}
