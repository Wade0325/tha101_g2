package tw.idv.petpet.web.clinicMember.service;

import java.util.List;

import tw.idv.petpet.core.service.CoreService;
import tw.idv.petpet.web.clinicMember.entity.ClinicMember;

public interface ClinicMemberService extends CoreService {

	ClinicMember register(ClinicMember clinicMember);

	List<ClinicMember> findAll();

	boolean remove(Integer clinicId);
	
	boolean save (ClinicMember clinicMember);
	
	ClinicMember edit(ClinicMember clinicMember);

	ClinicMember login(ClinicMember clinicMember);
}
