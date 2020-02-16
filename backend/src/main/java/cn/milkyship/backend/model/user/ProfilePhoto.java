package cn.milkyship.backend.model.user;
/*
 * <p>项目名称: netdisk </p>
 * <p>文件名称: ProfilePhoto </p>
 * <p>描述: 用户头像实体类 </p>
 * <p>创建时间: 2020/2/16 </p>
 * <a href="mail to: xuyunkai@mail.nankai.edu.cn">徐云凯</a>
 * @author 徐云凯
 * @version v1.0
 */

public class ProfilePhoto {
	
	private String id;
	private byte[] image;
	
	public ProfilePhoto() {
	}
	
	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	public byte[] getImage() {
		return image;
	}
	
	public void setImage(byte[] image) {
		this.image = image;
	}
}
