package com.codemusik;

import com.codemusik.dao.BlogRepository;
import com.codemusik.dao.UserRepository;
import com.codemusik.po.Blog;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BlogApplicationTests {

	@Autowired
	private BlogRepository blogRepository;

	@Test
	public void contextLoads() {
		Blog blog = blogRepository.findOne(2l);
		for (int i = 0; i < 10; i++) {
			long id = 20 * (i+1) + 1l;
			blog.setId(id);
			blogRepository.save(blog);
		}
	}

}
