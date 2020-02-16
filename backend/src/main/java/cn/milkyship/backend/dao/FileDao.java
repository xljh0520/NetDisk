package cn.milkyship.backend.dao;

import cn.milkyship.backend.model.fileSystem.FSObject;
import cn.milkyship.backend.model.fileSystem.NetDirectory;
import cn.milkyship.backend.model.fileSystem.NetFile;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component
public interface FileDao {

	public int isDir(String FSObjId);
	
	public void add(NetDirectory dir);
	
	public void add(NetFile file);
	
	public void del(String FileId);
	
	public FSObject find(String FSObjId);
	
	public NetDirectory findDir(String DirId);
	
	public NetFile findFile(String FileId);
	
	public List<NetDirectory> findChildrenDir(String FSObjectId);
	
	public List<NetFile> findChildrenFile(String FSObjectId);
	
}
