package cn.milkyship.backend.fao;

import org.springframework.stereotype.Component;

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
public class FileIOController extends BaseFao implements Runnable {
	
	/**
	 * When an object implementing interface <code>Runnable</code> is used
	 * to create a thread, starting the thread causes the object's
	 * <code>run</code> method to be called in that separately executing
	 * thread.
	 * <p>
	 * The general contract of the method <code>run</code> is that it may
	 * take any action whatsoever.
	 *
	 * @see Thread#run()
	 */
	@Override
	public void run() {
		// TODO: 磁盘写入
	}
}
