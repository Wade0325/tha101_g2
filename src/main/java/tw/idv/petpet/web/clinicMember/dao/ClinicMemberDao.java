package tw.idv.petpet.web.clinicMember.dao;

import tw.idv.petpet.core.dao.CoreDao;
import tw.idv.petpet.web.clinicMember.entity.ClinicMember;

public interface ClinicMemberDao extends CoreDao<ClinicMember, Integer> {

	ClinicMember selectByClinicName(String clinicName);
	
	ClinicMember selectForLogin(String clinicEmail, String clinicPassword);
}
