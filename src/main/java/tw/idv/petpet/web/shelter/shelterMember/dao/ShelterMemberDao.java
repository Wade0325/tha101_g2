package tw.idv.petpet.web.shelter.shelterMember.dao;

import tw.idv.petpet.core.dao.CoreDao;
import tw.idv.petpet.web.shelter.shelterMember.entity.ShelterMember;

public interface ShelterMemberDao extends CoreDao<ShelterMember, Integer>{

	ShelterMember selectByShelterName(String shelterName);

	ShelterMember selectForLogin(String shelterEmail, String shelterPassword);
}
