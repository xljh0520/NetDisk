package cn.milkyship.backend.controller;

import cn.milkyship.backend.model.fileSystem.FSObject;
import cn.milkyship.backend.service.FileIOService;
import cn.milkyship.backend.service.FileManageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/*
 * <p>项目名称: netdisk </p>
 * <p>文件名称: FileController </p>
 * <p>描述: 接收文件操作相关请求 </p>
 * <p>创建时间: 2020-2-5 </p>
 * <a href="mail to: xuyunkai@mail.nankai.edu.cn">徐云凯</a>
 * @author 徐云凯
 * @version v1.0
 */

@RestController
@RequestMapping (value="/file")     // 通过这里配置使下面的映射都在/users下
public class FileController {

	@Autowired
	private FileIOService fileIOService;
	@Autowired
	private FileManageService fileManageService;
	
	@RequestMapping(value="/test/{id}", method= RequestMethod.GET)
	public List<FSObject> test(@PathVariable String id) {
		FSObject fsObject = new FSObject();
		fsObject.setId(id);
		fsObject.setFileName("abcTstFile.txt");
		fsObject.setOwner("owner123");
		fsObject.setParent("parent123");
		fsObject.setFilePath("/root/data/");
		List<FSObject> list = new ArrayList<>();
		list.add(fsObject);
		return list;
	}
	
	@RequestMapping(value = "ls/{id}", method = RequestMethod.GET)
	public List<FSObject> ls(@PathVariable String id) {
		// 处理"/files/{uuid}}"的GET请求，用来读取文件目录
		return fileManageService.findChild(id);
	}
	
//	@RequestMapping(value="/", method=RequestMethod.POST)
//	public String postUser(@ModelAttribute User user) {
//		// 处理"/users/"的POST请求，用来创建User
//		// 除了@ModelAttribute绑定参数之外，还可以通过@RequestParam从页面中传递参数
//		users.put(user.getId(), user);
//		return "success";
//	}
//
//	@RequestMapping(value="/download/{id}", method=RequestMethod.GET)
//	public MultipartFile getUser(@PathVariable String id) {
//		// 处理"/users/{id}"的GET请求，用来获取url中id值的User信息
//		// url中的id可通过@PathVariable绑定到函数的参数中
//		File file = fileIOService.download(id);
//
//		if(!file.exists())
//			return null;
//
//
//	}
//
//	@RequestMapping(value="/{id}", method=RequestMethod.PUT)
//	public String putUser(@PathVariable Long id, @ModelAttribute User user) {
//		// 处理"/users/{id}"的PUT请求，用来更新User信息
//		User u = users.get(id);
//		u.setName(user.getName());
//		u.setAge(user.getAge());
//		users.put(id, u);
//		return "success";
//	}
//
//	@RequestMapping(value="/{id}", method=RequestMethod.DELETE)
//	public String deleteUser(@PathVariable Long id) {
//		// 处理"/users/{id}"的DELETE请求，用来删除User
//		users.remove(id);
//		return "success";
//	}
	
}
