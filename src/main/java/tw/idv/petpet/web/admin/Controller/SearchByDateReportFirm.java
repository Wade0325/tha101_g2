package tw.idv.petpet.web.admin.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tw.idv.petpet.web.admin.Entity.ReportFirmEntity;
import tw.idv.petpet.web.admin.Repository.ReportFirmRepository;
import tw.idv.petpet.web.admin.dto.ReportFirmDateVO;

@RestController
@RequestMapping("/admin")
public class SearchByDateReportFirm {
	@Autowired
	private ReportFirmRepository reportFirmRepository;

	@PostMapping("/getreportfirmbydate")
	public Optional<List<ReportFirmEntity>> getReportFirmByDate(@RequestBody ReportFirmDateVO date) {
		System.out.println("開始時間: " + date.getStartdate());
		System.out.println("結束時間: " + date.getEnddate());
		Optional<List<ReportFirmEntity>> ReportFirmOpt = reportFirmRepository.findByFirmDate(date.getStartdate(),
				date.getEnddate());
		System.out.println(ReportFirmOpt);
		return reportFirmRepository.findByFirmDate(date.getStartdate(), date.getEnddate());
	}
}
