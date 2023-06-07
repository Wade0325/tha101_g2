package com.web.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import tw.idv.petpet.web.admin.Entity.AdminEntity;
import tw.idv.petpet.web.admin.Repository.AdminRepository;
import tw.idv.petpet.web.admin.dto.AdminUpdateVO;

@RestController
public class EditController {
	@Autowired
	private AdminRepository adminRepository;
	//先取得資料放進前端資料
	@PostMapping("admin/edit")
	public AdminEntity edit(HttpSession session) {
		AdminEntity adminEntity = (AdminEntity) session.getAttribute("loginAdminEntity");
		System.out.println("test1 : 查詢個人Session");
		System.out.println("test1 :" + adminEntity);
		return adminEntity;
	}
	//2.再從表單輸入值做修改
	@PostMapping("admin/update")
	public AdminEntity update(@RequestBody AdminUpdateVO adminUpdateVO, AdminEntity adminEntity) {
		System.out.println("test1 : 進入編輯方法");
		System.out.println("adminUpdateVO : " + adminUpdateVO);
//		System.out.println("adminEntity : " + adminEntity);
//		透過ID去db找看有沒有這筆資料
		AdminEntity adminEntityCheck = adminRepository.findByAdminId(adminUpdateVO.getAdminId());
		System.out.println("test2 是否有這筆資料 " + adminEntityCheck);
		if (adminEntityCheck != null) {
			if(adminUpdateVO.getAdminName().equals("") || adminUpdateVO.getAdminName() == null) {
				System.out.println("test3 名稱是否為空: " + "YES");
				adminEntity.setAdminId(adminEntityCheck.getAdminId());
				adminEntity.setAdminName(adminEntityCheck.getAdminName());
				adminEntity.setAdminAccount(adminEntityCheck.getAdminAccount());
				
				adminEntity.setAdminPassword(adminUpdateVO.getAdminPassword());
				System.out.println("更新完的資料 " +adminEntity);
				return adminEntity;
			}else if(adminUpdateVO.getAdminPassword().isEmpty() || adminUpdateVO.getAdminPassword() == null) {
				System.out.println("test3 密碼是否為空: " + "YES");
				adminEntity.setAdminId(adminEntityCheck.getAdminId());
				adminEntity.setAdminAccount(adminEntityCheck.getAdminAccount());
				adminEntity.setAdminPassword(adminEntityCheck.getAdminPassword());
				
				adminEntity.setAdminName(adminUpdateVO.getAdminName());
				System.out.println("更新完的資料 " +adminEntity);
				return adminEntity;
			}else {
				adminEntity.setAdminId(adminEntityCheck.getAdminId());
				adminEntity.setAdminAccount(adminEntityCheck.getAdminAccount());
				
				adminEntity.setAdminName(adminUpdateVO.getAdminName());
				adminEntity.setAdminPassword(adminUpdateVO.getAdminPassword());
				System.out.println("test3 名稱、密碼都有值:" + adminEntity);
				adminRepository.save(adminEntity);
				System.out.println("更新完的資料 " +adminEntity);
				return adminEntity;
			}
		} else {
			return null;
		}
	}

}

//	@PutMapping("admin/update/{adminId}")
//	public AdminEntity update(@PathVariable String adminId, @RequestBody AdminUpdateVO adminUpdateVO, AdminEntity adminEntity ) {
//		System.out.println("test1 : 進入編輯方法");
//		System.out.println("test1 :" + adminId);
//		adminEntity.setAdminName(adminUpdateVO.getAdminName());
//		adminEntity.setAdminAccount(adminUpdateVO.getAdminAccount());
//		adminEntity.setAdminPassword(adminUpdateVO.getAdminPassword());
//		System.out.println("test2 :" + adminEntity.getAdminAccount());
//		adminRepository.save(adminEntity);
//		return adminEntity;
//
//	}