package cn.bdqn.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * 为什么要把这个类 设置成单例模式！
 *      因为 我们所有的用户公用一个properties文件就可以了！
 *      
 *     目的就是只加载一次配置文件!!!
 * 
 * 
 * 失去一日甚易,欲得回已无途！
 *  
 * @author 小葱拌豆腐
 * 2017-7-14上午8:46:24
 */
public class ConfigManager {
	// 01.创建静态的自身对象 饿汉
	private static ConfigManager configManager;
	// 创建Properties对象 读取jdbc.properties文件
	private static Properties properties;

	// 02.私有化构造
	static {
		String path = "jdbc.properties";
		properties = new Properties();
		// 创建输入流对象
		InputStream stream = ConfigManager.class.getClassLoader()
				.getResourceAsStream(path);
		try {
			properties.load(stream); // properties文件加载到内存中
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				stream.close(); // 关闭流
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	// 03.创建供外部访问的接口
	public static synchronized ConfigManager getInstance() {
		return configManager;
	}

	// properties文件是键值对的形式！ 我们提供key 目的获取value
	public static String getValue(String key) {
		return properties.getProperty(key);
	}

}
