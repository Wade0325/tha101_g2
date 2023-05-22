package tw.idv.petpet.web.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tw.idv.petpet.web.user.entity.EmailDetails;

@RestController
@RequestMapping("user/verify")
public class verifyController {
	@Autowired
	private EmailDetails details;

	@PostMapping
	public String verify() {
		return details.getVerifiCode();
	}
}
