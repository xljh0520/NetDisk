package cn.milkyship.backend.model.fileSystem;

/*
 * <p>项目名称: backend </p>
 * <p>文件名称: FSObject </p>
 * <p>描述: 文件系统相关类型的基类 </p>
 * <p>创建时间: 2020-1-12 </p>
 * <a href="mail to: xuyunkai@mail.nankai.edu.cn">徐云凯</a>
 * @author 徐云凯
 * @version v1.0
 */

public class FSObject {
	
	private String id;
	private String fileName;
	private String owner;
	private String parent;
	private String filePath;
	
	public FSObject(){};
	
	public FSObject(FSObject fsObject){
		this.id = fsObject.id;
		this.fileName = fsObject.fileName;
		this.owner = fsObject.owner;
		this.parent = fsObject.parent;
		this.filePath = fsObject.filePath;
	}
	
	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	public String getFileName() {
		return fileName;
	}
	
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	
	public String getOwner() {
		return owner;
	}
	
	public void setOwner(String owner) {
		this.owner = owner;
	}
	
	public String getParent() {
		return parent;
	}
	
	public void setParent(String parent) {
		this.parent = parent;
	}
	
	public String getFilePath() {
		return filePath;
	}
	
	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}
}
