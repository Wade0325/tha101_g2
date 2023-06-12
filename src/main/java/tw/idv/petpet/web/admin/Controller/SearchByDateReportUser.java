package tw.idv.petpet.web.admin.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import tw.idv.petpet.web.admin.Entity.ReportUserEntity;
import tw.idv.petpet.web.admin.Repository.ReportUserRepository;
import tw.idv.petpet.web.admin.dto.ReportUserDateVO;

@RestController
public class SearchByDateReportUser {
	@Autowired
	private ReportUserRepository reportUserRepository;

	@PostMapping("/getreportuserbydate")
	public Optional<List<ReportUserEntity>> getReportUserByDate(@RequestBody ReportUserDateVO date) {
		System.out.println("開始時間: " + date.getStartdate());
		System.out.println("結束時間: " + date.getEnddate());
		Optional<List<ReportUserEntity>> ReportUserOpt = reportUserRepository.findByUserDate(date.getStartdate(), date.getEnddate());
		System.out.println(ReportUserOpt);
		return reportUserRepository.findByUserDate(date.getStartdate(), date.getEnddate());
	}
}
