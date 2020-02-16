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
import java.util.UUID;

@Service
@Component
public class FileManageService {

	@Autowired
	private FileDao fileDao;
	
	public String mkdir(String parentId, String fileName){
		if(fileDao.isDir(parentId)==0) {return null;}
		
		NetDirectory parent = (NetDirectory)fileDao.findDir(parentId);
		
		NetDirectory netDirectory = new NetDirectory();
		
		String uuid = UUID.randomUUID().toString();
		netDirectory.setId(uuid.replaceAll("-", ""));
		netDirectory.setFileName(fileName);
		netDirectory.setParent(parentId);
		netDirectory.setOwner(parent.getOwner());
		netDirectory.setFilePath(parent.getFilePath() + parent.getFileName() + '/');
		
		return netDirectory.getId();
	}
	
	public List<FSObject> findChild( String ManipulatedFileId){
		List<FSObject> children = new ArrayList<>();
		if(fileDao.isDir(ManipulatedFileId)==1){
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
	
	public String cut(String ManipulatedFileId, String targetDirId){
		// 验证目标位置为文件夹而不是文件
		if(fileDao.isDir(targetDirId)==0){return "";}
		String re = copy(ManipulatedFileId, targetDirId);
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
	public String copy(String ManipulatedFileId, String targetDirId){
		// 验证目标位置为文件夹而不是文件
		if(fileDao.isDir(targetDirId)==0){return null;}
		
		String ownerId = fileDao.findDir(targetDirId).getOwner();
		
		if(fileDao.isDir(ManipulatedFileId)==1){   //被复制对象为文件夹
			String ManipulatedDirName = fileDao.findDir(ManipulatedFileId).getFileName();
			String re = mkdir(targetDirId, ManipulatedDirName);
			
			//复制被复制对象目录下的文件
			List<NetFile> childrenFile = fileDao.findChildrenFile(ManipulatedFileId);
			for(NetFile child:childrenFile){
				NetFile childFile = new NetFile(child);
				String uuid = UUID.randomUUID().toString();
				childFile.setId(uuid.replaceAll("-", ""));
				childFile.setParent(re);
				childFile.setOwner(ownerId);
				fileDao.add(childFile);
			}
			//复制被复制对象下的文件夹
			List<NetDirectory> childrenDir = fileDao.findChildrenDir(ManipulatedFileId);
			for(NetDirectory child:childrenDir){
				String dirId = mkdir(targetDirId, child.getFileName());
				copy(child.getId(), dirId);
			}
			return re;
		}
		else{   //被复制对象为文件
			NetFile file = fileDao.findFile(ManipulatedFileId);
			String uuid = UUID.randomUUID().toString();
			file.setId(uuid.replaceAll("-", ""));
			file.setParent(targetDirId);
			file.setOwner(ownerId);
			fileDao.add(file);
			return file.getId();
		}
	}

	public void del(String ManipulatedFileId){
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
