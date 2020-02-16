package cn.milkyship.backend.dao;

/*
 * <p>项目名称: netdisk </p>
 * <p>文件名称: ProfilePhotoDao </p>
 * <p>描述: 用户头像控制使用的DAO </p>
 * <p>创建时间: 2020/2/16 </p>
 * <a href="mail to: xuyunkai@mail.nankai.edu.cn">徐云凯</a>
 * @author 徐云凯
 * @version v1.0
 */

import cn.milkyship.backend.model.user.ProfilePhoto;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

@Mapper
@Component
public interface ProfilePhotoDao {
	
	// https://blog.csdn.net/qq_38785658/article/details/75009700
	public void addPhoto(ProfilePhoto profilePhoto);
	
	public ProfilePhoto findPhoto(String id);
}
