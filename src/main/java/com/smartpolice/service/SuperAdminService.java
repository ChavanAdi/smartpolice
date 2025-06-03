package com.smartpolice.service;

import org.springframework.web.multipart.MultipartFile;

import com.smartpolice.dto.SuperAdminDto;
import com.smartpolice.entity.SuperAdminDataMaster;

public interface SuperAdminService {

	public SuperAdminDataMaster addSuperAdmin(SuperAdminDto adminDto, MultipartFile file);

	public SuperAdminDataMaster getAdminDataById(long adminId);
}
