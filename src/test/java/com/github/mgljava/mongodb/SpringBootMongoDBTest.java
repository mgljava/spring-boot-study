package com.github.mgljava.mongodb;

import static org.junit.Assert.assertEquals;

import com.github.mgljava.SpringBootStudyApplication;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = {SpringBootStudyApplication.class})
public class SpringBootMongoDBTest {

  @Autowired
  private UserRepository userRepository;

  @Before
  public void setUp() {
    userRepository.deleteAll();
  }

  @Test
  public void test() {
    userRepository.save(new User(1L, "zhangsan", 20));
    userRepository.save(new User(2L, "lisi", 30));
    userRepository.save(new User(3L, "wangwu", 40));

    assertEquals(3, userRepository.findAll().size());

    // 删除一个User，再验证User总数
    User user = userRepository.findById(1L).get();
    userRepository.delete(user);
    assertEquals(2, userRepository.findAll().size());

    // 删除一个User，再验证User总数
    user = userRepository.findByUsername("lisi");
    userRepository.delete(user);
    assertEquals(1, userRepository.findAll().size());
  }
}
