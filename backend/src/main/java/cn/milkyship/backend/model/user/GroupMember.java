package cn.milkyship.backend.model.user;

/*
 * <p>项目名称: netdisk </p>
 * <p>文件名称: GroupMember </p>
 * <p>描述: 群组成员实体类 </p>
 * <p>创建时间: 2020/2/16 </p>
 * <a href="mail to: xuyunkai@mail.nankai.edu.cn">徐云凯</a>
 * @author 徐云凯
 * @version v1.0
 */

public class GroupMember extends User {
	
	private String groupUuid;
	private String nameInGroup;
	private int level;
	private String memClass;
	
	public GroupMember() {}
	
	public String getGroupUuid() {
		return groupUuid;
	}
	
	public void setGroupUuid(String groupUuid) {
		this.groupUuid = groupUuid;
	}
	
	public String getNameInGroup() {
		return nameInGroup;
	}
	
	public void setNameInGroup(String nameInGroup) {
		this.nameInGroup = nameInGroup;
	}
	
	public int getLevel() {
		return level;
	}
	
	public void setLevel(int level) {
		this.level = level;
	}
	
	public String getMemClass() {
		return memClass;
	}
	
	public void setMemClass(String memClass) {
		this.memClass = memClass;
	}
}
