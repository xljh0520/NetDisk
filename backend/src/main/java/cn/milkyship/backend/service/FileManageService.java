package cn.milkyship.backend.service;

import cn.milkyship.backend.dao.FileDao;
import cn.milkyship.backend.model.fileSystem.FSObject;
import cn.milkyship.backend.model.fileSystem.NetDirectory;
import cn.milkyship.backend.model.fileSystem.NetFile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Component
public class FileManageService {

	@Autowired
	private FileDao fileDao;
	
	public int mkdir(int parentId, String fileName){
		if(!fileDao.isDir(parentId)) {return -1;}
		
		NetDirectory parent = (NetDirectory)fileDao.findDir(parentId);
		
		NetDirectory netDirectory = new NetDirectory();
		
		netDirectory.setFileName(fileName);
		netDirectory.setParent(parentId);
		netDirectory.setOwner(parent.getOwner());
		netDirectory.setFilePath(parent.getFilePath() + parent.getFileName() + '/');
		
		return fileDao.add(netDirectory);
	}
	
	public List<FSObject> findChild( int ManipulatedFileId){
		List<FSObject> children = new ArrayList<>();
		if(fileDao.isDir(ManipulatedFileId)){
			List<NetDirectory> childrenDir = fileDao.findChildrenDir(ManipulatedFileId);
			if(childrenDir != null)
				children.addAll(childrenDir);
			List<NetFile> childrenFile = fileDao.findChildrenFile(ManipulatedFileId);
			if(childrenFile != null)
				children.addAll(childrenFile);
		}
		else {
			children.add(fileDao.findFile(ManipulatedFileId));
		}
		return children;
	}
	
	public int cut(int ManipulatedFileId, int targetDirId){
		if(!fileDao.isDir(targetDirId)){return -1;}
		int re = copy(ManipulatedFileId, targetDirId);
		del(ManipulatedFileId);
		return re;
	}
	
	/***
	 * @title: copy
	 * @description: 同一用户下的文件复制
	 * @param ManipulatedFileId: 被操作的文件id
	 * @param targetDirId: 目标文件夹id
	 * @return void
	 * @author  徐云凯
	 * @datetime  2020/2/6 14:39
	 */
	public int copy(int ManipulatedFileId, int targetDirId){
		if(!fileDao.isDir(targetDirId)){return -1;}
		
		int ownerId = fileDao.findDir(targetDirId).getOwner();
		
		if(fileDao.isDir(ManipulatedFileId)){   //被复制对象为文件夹
			String ManipulatedDirName = fileDao.findDir(ManipulatedFileId).getFileName();
			int re = mkdir(targetDirId, ManipulatedDirName);
			
			//复制被复制对象目录下的文件
			List<NetFile> childrenFile = fileDao.findChildrenFile(ManipulatedFileId);
			for(NetFile child:childrenFile){
				NetFile childFile = new NetFile(child);
				childFile.setParent(re);
				childFile.setOwner(ownerId);
				fileDao.add(childFile);
			}
			//复制被复制对象下的文件夹
			List<NetDirectory> childrenDir = fileDao.findChildrenDir(ManipulatedFileId);
			for(NetDirectory child:childrenDir){
				int dirId = mkdir(targetDirId, child.getFileName());
				copy(child.getId(), dirId);
			}
			return re;
		}
		else{   //被复制对象为文件
			NetFile file = fileDao.findFile(ManipulatedFileId);
			file.setParent(targetDirId);
			file.setOwner(ownerId);
			return fileDao.add(file);
		}
	}

	public void del(int ManipulatedFileId){
		List<FSObject> children = findChild(ManipulatedFileId);
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
