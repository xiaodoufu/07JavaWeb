package cn.bdqn.util;

import java.util.Map;
import java.util.Set;

import org.apache.log4j.Logger;

import com.danga.MemCached.MemCachedClient;
import com.danga.MemCached.SockIOPool;

public class MemcachedUtil {
	// 创建memcached客户端对象
	private static MemCachedClient client = new MemCachedClient();
	private static MemcachedUtil memcached = new MemcachedUtil();
	private static Logger log = Logger.getLogger(MemcachedUtil.class);
	static {
		log.debug("缓存实例化");
		// memcached缓存地址，因为是分布式缓存所以为数组,memcached默认端口号为11211
		String[] servers = { "127.0.0.1:11211" };
		// 为该servers设置权重，设置保存的优先级与缓存服务器列表一致
		Integer[] weights = { 3 };
		/*
		 * 创建缓存连接池,调用SchoonerSockIOPool.getInstance()方法 在调用getInstance(String
		 * s,boolean flag)s:"default",flag:true 在调用受保护的构造方法isTcp=flag
		 */
		// 默认采用TCP协议
		SockIOPool pool = SockIOPool.getInstance();
		// SockIOPool调用SchoonerSockIOPool类的setServers方法
		pool.setServers(servers);// 将memcached缓存地址给连接池
		pool.setWeights(weights);// 将memcached缓存权重给连接池
		// 设置是否查找所有服务器，默认值：true
		pool.setFailover(true);
		// 设置初始化时对每个服务器建立的连接数目，为SchoonerSockIOPool类中的minConn赋值
		pool.setInitConn(5);
		/*
		 * 每个服务器建立最小的连接数，当自查线程发现与某个服务器建立连接数目小于这个数目时会弥补剩下的连接 默认值为8
		 */
		pool.setMinConn(5);
		// 每个服务器建立最大的连接数，默认值32
		pool.setMaxConn(250);
		// 设置最大处理时间，单位：毫秒，默认1000毫秒，参数类型long，
		pool.setMaxIdle(1000 * 60 * 60 * 6);
		// 设置主线程睡眠时间，单位：毫秒，默认30000毫秒，参数类型long，主线程周期性工作
		pool.setMaintSleep(30000);
		// Socket的参数，如果是true在写数据时不缓冲，立即发送出去，默认值为：false；
		pool.setNagle(false);
		// 设置读取数据超时时间，默认：3000，单位不明。。。
		pool.setSocketTO(3000);
		// 设置是否每次查询检查连接是否可用，默认false不检查
		pool.setAliveCheck(true);
		// 初始化完毕，底层调用SchoonerSockIOPool类中的initialize方法
		pool.initialize();
	}

	private MemcachedUtil() {
	}// 私有化构造方法

	public static MemcachedUtil getInstance() {// 对外提供接口
		return memcached;
	}

	/**
	 *  下面的缓存中数据的增删改查 都可以设置 销毁时间
	 *   底层都有提供方法重载
	 */
	public boolean set(String key, Object value) {
		log.debug("缓存set：key值是：" + key);
		log.debug("是否放进缓存：" + client.set(key, value));
		return client.set(key, value);// 如果set的key已经存在，该命令可以更新该key所对应的原来的数据，也就是实现更新的作用。
	}

	public boolean add(String key, Object value) {// 添加缓存中对象方法
		return client.add(key, value);
	}

	public boolean delete(String key) {
		return client.delete(key);
	}

	public boolean replace(String key, Object value) {// 替换缓存中的对象方法
		return client.replace(key, value);
	}

	public Object get(String key) {// 获取缓存中对象的方法
		return client.get(key);
	}

	public boolean flushAll() {
		Map map = client.stats(); // stats 命令用于返回统计信息例如 PID(进程号)、版本号、连接数等。
		Set entrySet = map.entrySet();
		for (Object object : entrySet) {
			log.debug(object);
		}
		return client.flushAll();
	}

}
