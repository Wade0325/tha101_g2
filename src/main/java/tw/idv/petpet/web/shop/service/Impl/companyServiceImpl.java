package tw.idv.petpet.web.shop.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import tw.idv.petpet.web.shop.dao.CompanyRepository;
import tw.idv.petpet.web.shop.entity.Company;
import tw.idv.petpet.web.shop.service.companyService;
import tw.idv.petpet.web.user.dao.UserRepository;
import tw.idv.petpet.web.user.entity.User;
import tw.idv.petpet.web.user.service.UserService;

@Service
@Transactional
public class companyServiceImpl implements companyService{

	
	@Autowired
	private CompanyRepository companyRepository;
	
	

	@Override
	public Company login(Company company) {
		// TODO Auto-generated method stub
		Company companyLogin = companyRepository.findByAccountAndPassword(company.getCompany_email(), company.getCompany_password());
		if (companyLogin != null) {
			companyLogin.setSuccessful(true);
			companyLogin.setLogin(true);
			System.out.println("登入成功");
			return companyLogin;
		} else {
			company.setSuccessful(false);
			company.setMessage("帳號密碼錯誤");
			System.out.println("登入失敗");
			return null;
		}
	}
}
