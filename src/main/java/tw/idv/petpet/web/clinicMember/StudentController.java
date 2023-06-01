//package tw.idv.petpet.web.clinicMember;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.DeleteMapping;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.PutMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RestController;
//
//@RestController
//public class StudentController {
//
//	@Autowired
//	private StudentRepository studentRepository;
//
//	@PostMapping("/students")
//	public String insert(@RequestBody Student student) {
//		studentRepository.save(student);
//		return "執行資料庫的create操作";
//	}
//
//	@PutMapping("/students/{studentId}")
//	public String update(@PathVariable Integer studentId, @RequestBody Student student) {
//
//		Student student1 = studentRepository.findById(studentId).orElse(null);
//		if (student1 != null) {
//			student1.setName(student1.getName());
//			studentRepository.save(student1);
//			return "執行資料庫的update操作";
//		} else {
//			return "數據不存在，失敗";
//		}
//	}
//
//	@DeleteMapping("/students/{studentId}")
//	public String delete(@PathVariable Integer studentId) {
//
//		studentRepository.deleteById(studentId);
//		return "執行資料庫的delete操作";
//	}
//
//	@GetMapping("/students/{studentId}")
//	public Student read(@PathVariable Integer studentId) {
//		Student student = studentRepository.findById(studentId).orElse(null);
//		return student;
//	}
//
//}
