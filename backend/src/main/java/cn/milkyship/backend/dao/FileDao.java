package cn.milkyship.backend.dao;

import cn.milkyship.backend.model.fileSystem.NetDirectory;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

@Mapper
@Component
public interface FileDao {

	public boolean isDir();
	
	public void mkdir(NetDirectory netDirectory);
	
	public void del(int FileId);
	
	// TODO : 完善几个DAO
}
