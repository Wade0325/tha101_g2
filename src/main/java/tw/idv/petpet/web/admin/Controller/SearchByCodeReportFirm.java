package tw.idv.petpet.web.admin.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tw.idv.petpet.web.admin.Entity.ReportFirmEntity;
import tw.idv.petpet.web.admin.Repository.ReportFirmRepository;
import tw.idv.petpet.web.admin.dto.ReportFirmCodeVO;


@RestController
@RequestMapping("/admin")
public class SearchByCodeReportFirm {
	@Autowired
	private ReportFirmRepository reportFirmRepository;
	@PostMapping("/getreportfirmbycode")
	public List<ReportFirmEntity> getReportFirmByCode(@RequestBody ReportFirmCodeVO reportFirmCodeVO) {
		System.out.println(reportFirmCodeVO.getConfirmCode());
		List<ReportFirmEntity> reportFirmEntity = reportFirmRepository.findByConfirmCode(reportFirmCodeVO.getConfirmCode());
		System.out.println(reportFirmEntity);
		return reportFirmEntity;
	}
}
