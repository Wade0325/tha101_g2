package tw.idv.petpet.web.shelter.shelterMember.service;

import java.util.List;
import java.util.Optional;

import tw.idv.petpet.core.service.CoreService;
import tw.idv.petpet.web.shelter.shelterMember.entity.ShelterMember;

public interface ShelterMemberService extends CoreService{
	
	ShelterMember register(ShelterMember shelterMember);

	List<ShelterMember> findAll();
	
	

	boolean remove(Integer shelterMemberId);
	
	boolean save (ShelterMember shelterMemberMember);
	
	ShelterMember edit(ShelterMember shelterMemberMember);

}
