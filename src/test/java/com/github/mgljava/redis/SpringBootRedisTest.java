package com.github.mgljava.redis;

import static org.junit.Assert.assertEquals;

import com.github.mgljava.SpringBootStudyApplication;
import com.github.mgljava.domain.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = {SpringBootStudyApplication.class})
public class SpringBootRedisTest {

  @Autowired
  private StringRedisTemplate stringRedisTemplate;

  @Autowired
  private RedisTemplate<String, User> redisTemplate;

  @Test
  public void test() {
    stringRedisTemplate.opsForValue().set("name", "Monk");
    assertEquals("Monk", stringRedisTemplate.opsForValue().get("name"));
  }

  @Test
  public void test2() {
    // 保存对象
    User user = new User("name", 20);
    redisTemplate.opsForValue().set(user.getUsername(), user);

    final User name = redisTemplate.opsForValue().get("name");
    System.out.println(name.getUsername() + " --- " + name.getAge());
  }
}
