package tw.idv.petpet.web.admin.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import tw.idv.petpet.web.admin.Entity.ReportUserEntity;
import tw.idv.petpet.web.admin.Repository.ReportUserRepository;
import tw.idv.petpet.web.admin.dto.ReportUserFormVO;

@RestController
public class ReportUserFormController {
	@Autowired
	private ReportUserRepository reportUserRepository;

	@PostMapping("/reportuser/form")
	public ReportUserEntity form(@RequestBody ReportUserFormVO reportUserFormVO, ReportUserEntity reportUserEntity) {
		System.out.println("ReportUserForm 取得資料");
		System.out.println("test1 :" + reportUserFormVO);
		reportUserEntity.setUserId(reportUserFormVO.getUserId());
		reportUserEntity.setCompanyId(reportUserFormVO.getCompanyId());
		reportUserEntity.setUserContent(reportUserFormVO.getUserContent());
		System.out.println("ReportUserForm 儲存資料");
		System.out.println("test2 :" + reportUserEntity);
		reportUserRepository.save(reportUserEntity);
		System.out.println("ReportUserForm 儲存完成");
		System.out.println("test3 :" + reportUserEntity);
		return reportUserEntity;
	}
}
