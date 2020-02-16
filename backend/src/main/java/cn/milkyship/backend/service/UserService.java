package cn.milkyship.backend.service;

import cn.milkyship.backend.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
@Component
public class UserService {

	@Autowired
	private UserDao userDao;
	
	public void signUp(){
		// TODO:
	}
}
