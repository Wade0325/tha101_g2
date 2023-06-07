package com.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import tw.idv.petpet.web.admin.Entity.AdminEntity;
import tw.idv.petpet.web.admin.Repository.AdminRepository;
import tw.idv.petpet.web.admin.dto.AdminRegisterVO;

@RestController
public class RegisterController {

	@Autowired
	private AdminRepository adminRepository;

	@PostMapping("/admin/register")
	public Integer Register(@RequestBody AdminRegisterVO adminRegisterVO, AdminEntity adminEntity) {
		AdminEntity adminCheckEntity = adminRepository.findByAdminAccount(adminRegisterVO.getAdminAccount());
		System.out.println("test1: " + adminRegisterVO.getAdminAccount());
		System.out.println("test1: " + adminRegisterVO.getAdminPassword());
		if (adminCheckEntity == null) {
			if(!(adminRegisterVO.getAdminAccount()==null) || !(adminRegisterVO.getAdminAccount().equals(""))) {
				if(!(adminRegisterVO.getAdminPassword()==null) || !(adminRegisterVO.getAdminPassword().equals(""))) {
					System.out.println("test2: " + adminEntity);
					adminEntity.setAdminName(adminRegisterVO.getAdminName());
					System.out.println("test2: " + adminEntity.getAdminName());
					adminEntity.setAdminAccount(adminRegisterVO.getAdminAccount());
					System.out.println("test2: " + adminEntity.getAdminAccount());
					adminEntity.setAdminPassword(adminRegisterVO.getAdminPassword());
					System.out.println("test2: " + adminEntity.getAdminPassword());
					adminRepository.save(adminEntity);
					System.out.println("新增會員成功");
					return 1;
				} else {
					System.out.println("新增會員失敗");
					return 0;
				}
			}
			System.err.println("新增失敗");
			return 0;
		}else {
			System.out.println("新增會員失敗");
			return 0;
		}
	}
}
