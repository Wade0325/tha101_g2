package tw.idv.petpet.web.admin.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tw.idv.petpet.web.admin.Entity.ReportFirmEntity;
import tw.idv.petpet.web.admin.Repository.ReportFirmRepository;
import tw.idv.petpet.web.admin.dto.ReportFirmEditVO;
import tw.idv.petpet.web.admin.dto.ReportFirmSearchVO;

@RestController
@RequestMapping("/admin")
public class ReportFirmController {
	@Autowired
	private ReportFirmRepository reportFirmRepository;

	@GetMapping("/reportfirm/all")
	public List<ReportFirmEntity> getReportFirmAll() {
		List<ReportFirmEntity> list = reportFirmRepository.findAll();
		System.out.println("查詢ReportFirm全部資料成功");
		System.out.println(list);
		return list;
	}
//	透過編號查詢單筆資料
	@PostMapping("/reportfirm/getone")
	public ReportFirmEntity getReportFirmOneByFirmSn(@RequestBody ReportFirmSearchVO reportFirmSearchVO) {
		Integer reportFirmSn = reportFirmSearchVO.getFirmSn();
		ReportFirmEntity reportFirmEntity = reportFirmRepository.findByFirmSn(reportFirmSn);
		System.out.println("查詢編號為:" + reportFirmSn + "資料成功");
		System.out.println(reportFirmEntity);
		return reportFirmEntity;
	}
//  編輯檢舉表單
	@PostMapping("/reportfirm/edit")
	public ReportFirmEntity editReportFirm(@RequestBody ReportFirmEditVO reportFirmEditVO, ReportFirmEntity reportFirmEntity) {
		System.out.println("test1 接收資料: " + reportFirmEditVO);
		System.out.println("test1 送出資料: " + reportFirmEntity);
		reportFirmEntity.setFirmSn(reportFirmEditVO.getFirmSn());
		reportFirmEntity.setUserId(reportFirmEditVO.getUserId());
		reportFirmEntity.setCompanyId(reportFirmEditVO.getCompanyId());
		reportFirmEntity.setFirmContent(reportFirmEditVO.getFirmContent());
		reportFirmEntity.setFirmDate(reportFirmEditVO.getFirmDate());
		reportFirmEntity.setConfirmCode(reportFirmEditVO.getConfirmCode());
		reportFirmRepository.save(reportFirmEntity);
		System.out.println("test2 編輯完成資料: " + reportFirmEntity + "編輯成功");
		return reportFirmRepository.findByFirmSn(reportFirmEditVO.getFirmSn());
	}
}
