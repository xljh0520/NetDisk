package cn.milkyship.backend.service;

import cn.milkyship.backend.dao.FileDao;
import cn.milkyship.backend.fao.FileIOController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
@Component
public class FileIOService {
	
	@Autowired
	private FileDao fileDao;
	private FileIOController fileIOController;
	
	public void write(){
	
	}

	public void read(){
	
	}
	
	public void del(){
	
	}
}
