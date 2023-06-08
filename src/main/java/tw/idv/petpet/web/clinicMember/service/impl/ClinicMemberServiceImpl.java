package tw.idv.petpet.web.clinicMember.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import tw.idv.petpet.web.clinicMember.Repository.ClinicMemberRepository;
import tw.idv.petpet.web.clinicMember.dao.ClinicMemberDao;
import tw.idv.petpet.web.clinicMember.entity.ClinicMember;
import tw.idv.petpet.web.clinicMember.service.ClinicMemberService;

@Service
@Transactional
public class ClinicMemberServiceImpl implements ClinicMemberService {

	@Autowired
	private ClinicMemberDao clinicMemberDao;

	@Autowired
	private ClinicMemberRepository clinicMemberRepository;

	@Override
	public ClinicMember register(ClinicMember clinicMember) {
//		if (clinicMember.getClinicName() == null) {
//			clinicMember.setMessage("名稱未輸入");
//			clinicMember.setSuccessful(false);
//			return clinicMember;
//		}
//
//		if (clinicMember.getClinicPrincipal() == null) {
//			clinicMember.setMessage("負責人未輸入");
//			clinicMember.setSuccessful(false);
//			return clinicMember;
//		}
//
//		if (clinicMember.getClinicEmail() == null) {
//			clinicMember.setMessage("信箱未輸入");
//			clinicMember.setSuccessful(false);
//			return clinicMember;
//		}
//
//		if (clinicMemberDao.selectByClinicName(clinicMember.getClinicName()) != null) {
//			clinicMember.setMessage("名稱重複");
//			clinicMember.setSuccessful(false);
//			return clinicMember;
//		}
//
//		if (clinicMember.getClinicPassword() == null) {
//			clinicMember.setMessage("密碼未輸入");
//			clinicMember.setSuccessful(false);
//			return clinicMember;
//		}
//
//		if (clinicMember.getClinicPhone() == null) {
//			clinicMember.setMessage("電話未輸入");
//			clinicMember.setSuccessful(false);
//			return clinicMember;
//		}
//
//		if (clinicMember.getClinicAddress() == null) {
//			clinicMember.setMessage("地址未輸入");
//			clinicMember.setSuccessful(false);
//			return clinicMember;
//		}
//
//		if (clinicMember.getClinicService() == null) {
//			clinicMember.setMessage("服務項目未輸入");
//			clinicMember.setSuccessful(false);
//			return clinicMember;
//		}
//
//		final int id = clinicMemberDao.insert(clinicMember);
//		if (id < 1) {
//			clinicMember.setMessage("註冊有誤，請聯絡管理員!");
//			clinicMember.setSuccessful(false);
//			return clinicMember;
//		}
//
//		clinicMember.setMessage("註冊成功");
//		clinicMember.setSuccessful(true);
//
//		// 創建成功再新增日期
//		Timestamp currenTimestamp = new Timestamp(new Date().getTime());
//		clinicMember.setClinicMemberCreateDate(currenTimestamp);
//		clinicMember.setClinicMemberLastUpdateDate(currenTimestamp);
//
//		return clinicMember;

		ClinicMember clinicMemberRegister = clinicMemberRepository.findByClinicEmail(clinicMember.getClinicEmail());
		if (clinicMemberRegister != null) {
			clinicMemberRegister.setSuccessful(false);
			clinicMemberRegister.setMessage("帳號已存在");
		} else {
			return clinicMemberRepository.save(clinicMemberRegister);
		}
		return clinicMember;
	}

	@Override
	public ClinicMember getClinicMember(ClinicMember clinicMemberSession) {
		return clinicMemberRepository.findByClinicEmail(clinicMemberSession.getClinicEmail());
	}

	@Override
	public ClinicMember login(ClinicMember clinicMember) {
		ClinicMember clinicMemberLogin = clinicMemberRepository
				.findByClinicEmailAndPassword(clinicMember.getClinicEmail(), clinicMember.getClinicPassword());
		if (clinicMemberLogin != null) {
			clinicMemberLogin.setSuccessful(true);
			clinicMemberLogin.setLogin(true);
			return clinicMemberLogin;
		} else {
			clinicMember.setSuccessful(false);
			clinicMember.setMessage("帳號密碼錯誤");
			return clinicMember;
		}
	}

	
	public void update(Integer clinicId, ClinicMember clinicMember) {
		ClinicMember clinicMember1 = clinicMemberRepository.findById(clinicId).orElse(null);
		if (clinicMember1 != null) {
			clinicMember1.setClinicName(clinicMember.getClinicName());
			clinicMember1.setClinicPrincipal(clinicMember.getClinicPrincipal());
			clinicMember1.setClinicEmail(clinicMember.getClinicEmail());
			clinicMember1.setClinicPassword(clinicMember.getClinicPassword());
			clinicMember1.setClinicPhone(clinicMember.getClinicPhone());
			clinicMember1.setClinicMemberCreateDate(clinicMember.getClinicMemberCreateDate());
			clinicMember1.setClinicAddress(clinicMember.getClinicAddress());
			clinicMember1.setClinicPhoto1(clinicMember.getClinicPhoto1());
			clinicMember1.setClinicPhoto2(clinicMember.getClinicPhoto2());
			clinicMember1.setClinicPhoto3(clinicMember.getClinicPhoto3());
			clinicMember1.setClinicService(clinicMember.getClinicService());
			clinicMember1.setClinicMemberLastUpdateDate(clinicMember.getClinicMemberLastUpdateDate());
			clinicMemberRepository.save(clinicMember1);
		}
	}
	
	
	
	
	
	
	
	
	
	
	@Override
	public List<ClinicMember> findAll() {
		return clinicMemberDao.selectAll();
	}

	@Override
	public boolean remove(Integer clinicId) {
		return clinicMemberDao.deleteById(clinicId) > 0;
	}

	@Override
	public void save(ClinicMember clinicMember) {
		clinicMemberRepository.save(clinicMember);
	}

	@Override
	public ClinicMember edit(ClinicMember clinicMember) {
		// TODO Auto-generated method stub
		return null;
	}

//	@Override
//	public ClinicMember login(ClinicMember clinicMember) {
//		ClinicMember clinicMemberLogin = clinicMemberRepository.findByEmailAndPassword(clinicMember.getClinicEmail(),
//				clinicMember.getClinicPassword());
//		if (clinicMemberLogin != null) {
//			clinicMemberLogin.setSuccessful(true);
//			clinicMemberLogin.setLogin(true);
//			System.out.println("登入成功");
//			return clinicMemberLogin;
//		} else {
//			clinicMember.setSuccessful(false);
//			clinicMember.setMessage("帳號密碼錯誤");
//			System.out.println("登入失敗");
//			return clinicMember;
//		}
//	}
}
