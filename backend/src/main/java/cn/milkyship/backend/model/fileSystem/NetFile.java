package cn.milkyship.backend.model.fileSystem;

/*
 * <p>项目名称: backend </p>
 * <p>文件名称: NetFile </p>
 * <p>描述: 文件实体类 </p>
 * <p>创建时间: 2020-1-12 </p>
 * <a href="mail to: xuyunkai@mail.nankai.edu.cn">徐云凯</a>
 * @author 徐云凯
 * @version v1.0
 */
public class NetFile extends FSObject {
	
	private String MD5;
	
	public NetFile(){};
	
	public String getMD5() {
		return MD5;
	}
	
	public void setMD5(String MD5) {
		this.MD5 = MD5;
	}
}
