package com.ara.bbtgroup;

import com.ara.bbtgroup.entities.User;
import com.ara.bbtgroup.entities.UserRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BbtgroupApplicationTests {

	@Autowired
	private UserRepository userRepository;
	@Before
	public void setUp() throws Exception{
		User user = new User("Max", "Muster");

		assertNull(user.getId());
		this.userRepository.save(user);
		assertNotNull(user.getId());
	}

	@Test
	public void contextLoads() {
		User userA = userRepository.findByFirstname("Max");
		assertNotNull(userA);
	}
}
