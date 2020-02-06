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

	public boolean isDir(int FSObjId);
	
	public int add(NetDirectory dir);
	
	public int add(NetFile file);
	
	public void del(int FileId);
	
	public FSObject find(int FSObjId);
	
	public NetDirectory findDir(int DirId);
	
	public NetFile findFile(int FileId);
	
	public List<NetDirectory> findChildrenDir(int FSObjectId);
	
	public List<NetFile> findChildrenFile(int FSObjectId);
	
}
