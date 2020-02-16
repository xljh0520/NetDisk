package cn.milkyship.backend.dao;
/*
 * <p>项目名称: netdisk </p>
 * <p>文件名称: GroupDao </p>
 * <p>描述: 群组专用DAO </p>
 * <p>创建时间: 2020/2/16 </p>
 * <a href="mail to: xuyunkai@mail.nankai.edu.cn">徐云凯</a>
 * @author 徐云凯
 * @version v1.0
 */

import cn.milkyship.backend.model.user.Group;
import cn.milkyship.backend.model.user.GroupMember;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component
public interface GroupDao {
	
	public void add(Group group);
	
	public void del(String id);
	
	public void updateGroup(Group group);
	
	public Group findGroup(String UserId);
	
	public List<GroupMember> findGroupMember(String groupUuid);
}
