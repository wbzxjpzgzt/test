package com.baizhi.dao.cache;

import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;




import org.apache.ibatis.cache.Cache;
import org.apache.log4j.Logger;

import org.springframework.data.redis.serializer.JdkSerializationRedisSerializer;

import com.hyd.ssdb.SsdbClient;


public class SsdbCache implements Cache{
	static{
		System.out.println("++++++++++++缓存启动了++++++++++++=");
	}
    private static final Logger LOG = Logger.getLogger(SsdbCache.class);   
    
    private final ReadWriteLock readWriteLock = new ReentrantReadWriteLock(true);  
      
   //private RedisTemplate<Serializable, Serializable> redisTemplate =  (RedisTemplate<Serializable, Serializable>) SpringContextHolder.getBean("redisTemplate");   
    private SsdbClient client=new SsdbClient("192.168.174.131",8888);  
    private String id;  
      
    private JdkSerializationRedisSerializer jdkSerializer = new JdkSerializationRedisSerializer();  
    

	@Override
	public void clear() {
		// TODO Auto-generated method stub
		
	}
	public SsdbCache(final String id){
		if(id == null){  
            throw new IllegalArgumentException("Cache instances require an ID");  
        }  
        LOG.info("ssdb Cache id " + id);  
        this.id = id; 
	}
	@Override
	public String getId() {
		// TODO Auto-generated method stub
		return this.id;
	}

	@Override
	public Object getObject(Object key) {
		// TODO Auto-generated method stub
		try {  
            if(key != null){  
                Object obj =client.get(key.toString());  
                return jdkSerializer.deserialize((byte[])obj);   
            }  
        } catch (Exception e) {  
            LOG.error("ssdb ");  
        }
		client.close();
        return null;  
    
	}

	@Override
	public ReadWriteLock getReadWriteLock() {
		// TODO Auto-generated method stub
		return this.readWriteLock;
	}

	@Override
	public int getSize() {
		// TODO Auto-generated method stub
		int size=(int) client.dbsize(null);
		client.close();
        return size;
        
	}

	@Override
	public void putObject(Object key, Object value) {
		// TODO Auto-generated method stub
        if(value != null){  
            client.set(key.toString(), jdkSerializer.serialize(value));  
        } 
        client.close();
	}

	@Override
	public Object removeObject(Object key) {
        try {  
            if(key != null){  
                client.expire(key.toString(), 100);  
            }  
        } catch (Exception e) {
        	
        }
        client.close();
        return null; 
	}

}
