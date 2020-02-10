package cn.milkyship.backend.service;

import cn.milkyship.backend.dao.FileDao;
import cn.milkyship.backend.fao.FileIoObject;
import cn.milkyship.backend.model.fileSystem.NetFile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;

@Service
@Component
public class FileIOService {
	
	@Autowired
	private FileDao fileDao;
	@Autowired
	private FileIoObject fileIoObject;
	
	//TODO：处理文件加锁时的错误
	public int upload(MultipartFile file, String MD5){
		if(file.isEmpty())
			return 1;
		return fileIoObject.write(file, MD5);
	}
	
	public File download(int fileId){
		
		if(fileDao.isDir(fileId))
			return null;
		
		NetFile netFile = fileDao.findFile(fileId);
		
		return fileIoObject.read(netFile);
	}

	public int del(String MD5){
		return fileIoObject.del(MD5);
	}
}
