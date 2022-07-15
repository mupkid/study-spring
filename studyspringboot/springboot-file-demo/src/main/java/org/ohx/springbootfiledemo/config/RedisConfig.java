//package org.ohx.studybase.config;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.data.redis.connection.RedisConnectionFactory;
//import org.springframework.data.redis.core.*;
//import org.springframework.data.redis.serializer.StringRedisSerializer;
//
//public class RedisConfig {
//
//    @Autowired
//    private RedisConnectionFactory factory;
//
//    @Bean
//    public RedisTemplate<String, Object> redisTemplate() {
//        RedisTemplate<String, Object> redisTemplate = new RedisTemplate<>();
//        // key采用String的序列化方式
//        redisTemplate.setKeySerializer(new StringRedisSerializer());
//        // hash的key也采用String的序列化方式
//        redisTemplate.setHashKeySerializer(new StringRedisSerializer());
//        // hash的value序列化方式采用String的序列化方式
//        redisTemplate.setHashValueSerializer(new StringRedisSerializer());
//        // value序列化方式采用String的序列化方式
//        redisTemplate.setValueSerializer(new StringRedisSerializer());
//        redisTemplate.setConnectionFactory(factory);
//        return redisTemplate;
//    }
//
//    @Bean
//    public HashOperations<String, String, Object> hashOperations(RedisTemplate<String, Object> redisTemplate) {
//        return redisTemplate.opsForHash();
//    }
//
//    @Bean
//    public ValueOperations<String, String> valueOperations(RedisTemplate<String, String> redisTemplate) {
//        return redisTemplate.opsForValue();
//    }
//
//    @Bean
//    public ListOperations<String, Object> listOperations(RedisTemplate<String, Object> redisTemplate) {
//        return redisTemplate.opsForList();
//    }
//
//    @Bean
//    public SetOperations<String, Object> setOperations(RedisTemplate<String, Object> redisTemplate) {
//        return redisTemplate.opsForSet();
//    }
//
//    @Bean
//    public ZSetOperations<String, Object> zSetOperations(RedisTemplate<String, Object> redisTemplate) {
//        return redisTemplate.opsForZSet();
//    }
//}
