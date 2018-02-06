package util;

import java.util.Set;

import org.junit.Test;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

public class JedisUtil {
	private static JedisPool jedisPool;
	static {
		JedisPoolConfig config = new JedisPoolConfig();
		// 设置最大连接数
		config.setMaxTotal(20);

		// 设置连接时长
		config.setMaxWaitMillis(5000);

		// 设置最大存活数
		config.setMaxIdle(10);
		
		jedisPool = new JedisPool(config, "192.168.174.129", 9000);
	
	}

	public static Jedis getJedis() {

		Jedis jedis = jedisPool.getResource();

		return jedis;
	}

	public static void closeJedis(Jedis jedis) {

		jedis.close();
		
	}

	@Test
	public void test() {
		Jedis jedis = getJedis();

		jedis.select(1);

		/*jedis.zadd("down", 1, "01");
		jedis.zadd("down", 5, "02");
		jedis.zadd("down", 7, "03");
		jedis.zadd("down", 2, "05");*/
		//去除所有的  参数 1：key  参数2： 其实下标  参数3：结束下标
		Set<String> zrange = jedis.zrange("down", 0, -1);
		for (String key : zrange) {
			System.out.println(key);
			//参数 key  参数2 key对应的值
			Double zscore = jedis.zscore("down", key);
			System.out.println(zscore);
		}
		//默认  升序 从小到大 
		//排行榜  从大到小 zrevrange
		//结果
		
		
		
		
		//closeJedis(jedis);
        
		//jedis.setex("zhangsan", 1000, "123456");
		//closeJedis(jedis);
	}
}
