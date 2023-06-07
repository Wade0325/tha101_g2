package tw.idv.petpet.web.clinicMember.service.impl;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import tw.idv.petpet.web.clinicMember.Repository.ClinicMemberRepository;
import tw.idv.petpet.web.clinicMember.dao.ClinicMemberDao;
import tw.idv.petpet.web.clinicMember.entity.ClinicMember;
import tw.idv.petpet.web.clinicMember.service.ClinicMemberService;

@Service
public class ClinicMemberServiceImpl implements ClinicMemberService {

	@Autowired
	private ClinicMemberDao clinicMemberDao;

	@Autowired
	private ClinicMemberRepository clinicMemberRepository;

	@Transactional
	@Override
	public ClinicMember register(ClinicMember clinicMember) {
		if (clinicMember.getClinicName() == null) {
			clinicMember.setMessage("名稱未輸入");
			clinicMember.setSuccessful(false);
			return clinicMember;
		}

		if (clinicMember.getClinicPrincipal() == null) {
			clinicMember.setMessage("負責人未輸入");
			clinicMember.setSuccessful(false);
			return clinicMember;
		}

		if (clinicMember.getClinicEmail() == null) {
			clinicMember.setMessage("信箱未輸入");
			clinicMember.setSuccessful(false);
			return clinicMember;
		}

		if (clinicMemberDao.selectByClinicName(clinicMember.getClinicName()) != null) {
			clinicMember.setMessage("名稱重複");
			clinicMember.setSuccessful(false);
			return clinicMember;
		}

		if (clinicMember.getClinicPassword() == null) {
			clinicMember.setMessage("密碼未輸入");
			clinicMember.setSuccessful(false);
			return clinicMember;
		}

		if (clinicMember.getClinicPhone() == null) {
			clinicMember.setMessage("電話未輸入");
			clinicMember.setSuccessful(false);
			return clinicMember;
		}

		if (clinicMember.getClinicAddress() == null) {
			clinicMember.setMessage("地址未輸入");
			clinicMember.setSuccessful(false);
			return clinicMember;
		}

		if (clinicMember.getClinicService() == null) {
			clinicMember.setMessage("服務項目未輸入");
			clinicMember.setSuccessful(false);
			return clinicMember;
		}

		final int id = clinicMemberDao.insert(clinicMember);
		if (id < 1) {
			clinicMember.setMessage("註冊有誤，請聯絡管理員!");
			clinicMember.setSuccessful(false);
			return clinicMember;
		}

		clinicMember.setMessage("註冊成功");
		clinicMember.setSuccessful(true);

		// 創建成功再新增日期
		Timestamp currenTimestamp = new Timestamp(new Date().getTime());
		clinicMember.setClinicMemberCreateDate(currenTimestamp);
		clinicMember.setClinicMemberLastUpdateDate(currenTimestamp);

		return clinicMember;
	}

	@Override
	public List<ClinicMember> findAll() {
		return clinicMemberDao.selectAll();
	}

	@Transactional
	@Override
	public boolean remove(Integer clinicId) {
		return clinicMemberDao.deleteById(clinicId) > 0;
	}

	@Transactional
	@Override
	public boolean save(ClinicMember clinicMember) {
		return clinicMemberDao.update(clinicMember) > 0;
	}

	@Override
	public ClinicMember edit(ClinicMember clinicMember) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ClinicMember login(ClinicMember clinicMember) {
		ClinicMember clinicMemberLogin = clinicMemberRepository.findByEmailAndPassword(clinicMember.getClinicEmail(),
				clinicMember.getClinicPassword());
		if (clinicMemberLogin != null) {
			clinicMemberLogin.setSuccessful(true);
			clinicMemberLogin.setLogin(true);
			System.out.println("登入成功");
			return clinicMemberLogin;
		} else {
			clinicMember.setSuccessful(false);
			clinicMember.setMessage("帳號密碼錯誤");
			System.out.println("登入失敗");
			return clinicMember;
		}
	}
}
