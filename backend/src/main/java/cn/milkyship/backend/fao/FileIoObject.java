package cn.milkyship.backend.fao;

import cn.milkyship.backend.model.fileSystem.NetFile;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

/*
 * <p>项目名称: netdisk </p>
 * <p>文件名称: FileIOController </p>
 * <p>描述: 文件向服务器磁盘进行写入操作的控制器，多线程执行，线程安全 </p>
 * <p>创建时间: 2020-2-5 </p>
 * <a href="mail to: xuyunkai@mail.nankai.edu.cn">徐云凯</a>
 * @author 徐云凯
 * @version v1.0
 */

@Component
public class FileIoObject extends BaseFao{
	
	@Value ("${FileIO.HashBreakLength}")
	private int HashBreakLength;
	@Value("${FileIO.FileRootPath}")
	private String FileRootPath;
	
	public int write(MultipartFile multipartFile, String MD5){
		StringBuilder filePath = new StringBuilder(FileRootPath);
		for(int i = 0; i < MD5.length(); i += HashBreakLength){
			filePath.append(MD5.substring(i, i + HashBreakLength)).append("/");
		}
		
		// QUEST!!! 能一次性创建所有目录？
		File file = new File(filePath + MD5);
		try{
			multipartFile.transferTo(file);
		}
		catch (IOException ioE){
			ioE.printStackTrace();
			return 1;
		}
		
		return 0;
	}
	
	public File read(NetFile file){
		// TODO: 没有处理文件名和其他附加信息问题
		String fileMD5 = file.getMD5();
		StringBuilder filePath = new StringBuilder(FileRootPath);
		
		for(int i = 0; i < fileMD5.length(); i += HashBreakLength){
			filePath.append(fileMD5.substring(i, i + HashBreakLength)).append("/");
		}
		return new File(filePath.toString());
	}
	
	// 一般不用
	public int del(String MD5){
		return 0;
		// TODO:
	}
}
