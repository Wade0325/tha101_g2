package tw.idv.petpet.web.shelter.shelterMember.service.impl;

import java.util.List;

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
	@Override
	public ShelterMember login(ShelterMember ShelterMember) {
		ShelterMember login = repo.findByAccountAndPassword(ShelterMember.getShelterEmail(), ShelterMember.getShelterPassword());
		if (login != null) {
			login.setSuccessful(true);
			login.setLogin(true);
			System.out.println("登入成功");
			return login;
		} else {
			ShelterMember.setSuccessful(false);
			ShelterMember.setMessage("帳號密碼錯誤");
			System.out.println("登入失敗");
			return login;
		}
	}
	
}
