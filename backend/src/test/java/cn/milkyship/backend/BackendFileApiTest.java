package cn.milkyship.backend;

import cn.milkyship.backend.controller.FileController;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockServletContext;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/*
 * <p>项目名称: netdisk </p>
 * <p>文件名称: BackendFileApiTest </p>
 * <p>描述: 测试后台api接口可用性 </p>
 * <p>创建时间: 2020/2/15 </p>
 * <a href="mail to: xuyunkai@mail.nankai.edu.cn">徐云凯</a>
 * @author 徐云凯
 * @version v1.0
 */

@RunWith (SpringJUnit4ClassRunner.class)
@SpringBootTest (classes = MockServletContext.class)
@WebAppConfiguration
public class BackendFileApiTest {
	
	private MockMvc mvc;
	
	@Before
	public void setUp() throws Exception {
		mvc = MockMvcBuilders.standaloneSetup(new FileController()).build();
	}
	
	@Test
	public void testFileController() throws Exception  {
		// 测试FileController
		RequestBuilder request = null;
		
		// 1、get查一下某目录下的file列表,/test/后面的是get请求参数
		request = get("/file/test/test123");
		mvc.perform(request)
				.andExpect(status().isOk())
				.andExpect(content().string(equalTo("[{\"id\":\"id123\",\"fileName\":\"abcTstFile.txt\",\"owner\":\"owner123\",\"parent\":\"parent123\",\"filePath\":\"/root/data/\"}]")));
		
	}
	
}
