package cn.milkyship.backend.service;

/*
 * <p>项目名称: netdisk </p>
 * <p>文件名称: ProfilePhotoService </p>
 * <p>描述: 用户头像控制服务 </p>
 * <p>创建时间: 2020/2/16 </p>
 * <a href="mail to: xuyunkai@mail.nankai.edu.cn">徐云凯</a>
 * @author 徐云凯
 * @version v1.0
 */

import cn.milkyship.backend.dao.ProfilePhotoDao;
import cn.milkyship.backend.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
@Component
public class ProfilePhotoService {
	
	@Autowired
	private UserDao userDao;
	@Autowired
	private ProfilePhotoDao profilePhotoDao;
	
	public void addProfilePhoto(String UserId, byte[] image){
		// TODO:
	}
	
	public void updateProfilePhoto(String UserId, byte[] image){
		// TODO:
	}
}
