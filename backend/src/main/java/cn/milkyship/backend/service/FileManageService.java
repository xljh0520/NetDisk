package cn.milkyship.backend.service;

import cn.milkyship.backend.dao.FileDao;
import cn.milkyship.backend.model.fileSystem.FSObject;
import cn.milkyship.backend.model.fileSystem.NetDirectory;
import cn.milkyship.backend.model.fileSystem.NetFile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Component
public class FileManageService {

	@Autowired
	private FileDao fileDao;
	
	public void mkdir(){
	
	}
	
	public void findChild(List<FSObject> children){
	
	}
	
	public void cut(int ManipulatedFileId, int targetDirId){
		copy(ManipulatedFileId, targetDirId);
		del(ManipulatedFileId);
	}
	
	public void copy(int ManipulatedFileId, int targetDirId){
	
	}

	public void del(int ManipulatedFileId){
		List<FSObject> children = null;
		findChild(children);
		for(FSObject child:children){
			if(child instanceof NetFile){
				fileDao.del(child.getId());
			}
			else if(child instanceof NetDirectory){
				del(child.getId());
			}
		}
	}
}
