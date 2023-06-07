package tw.idv.petpet.web.admin.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import tw.idv.petpet.web.admin.Entity.ReportFirmEntity;
import tw.idv.petpet.web.admin.Repository.ReportFirmRepository;
import tw.idv.petpet.web.admin.dto.ReportFirmFormVO;

@RestController
public class ReportFirmFormController {
	@Autowired
	private ReportFirmRepository reportFirmRepository;
	
	@PostMapping("/reportfirm/form")
	public ReportFirmEntity form(@RequestBody ReportFirmFormVO reportFirmFormVO, ReportFirmEntity reportFirmEntity) {
		System.out.println("ReportFirmForm 取得資料");
		System.out.println("test1 :" + reportFirmFormVO);
		reportFirmEntity.setUserId(reportFirmFormVO.getUserId());
		reportFirmEntity.setCompanyId(reportFirmFormVO.getCompanyId());
		reportFirmEntity.setFirmContent(reportFirmFormVO.getFirmContent());
		System.out.println("ReportFirmForm 儲存資料");
		System.out.println("test2 :" + reportFirmEntity);
		reportFirmRepository.save(reportFirmEntity);
		System.out.println("ReportFirmForm 儲存完成");
		System.out.println("test3 :" + reportFirmEntity);
		return reportFirmEntity;
	}
}
