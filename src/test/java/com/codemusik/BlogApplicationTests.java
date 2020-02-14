package com.codemusik;

import com.codemusik.bo.TypeOrTagBlog;
import com.codemusik.dao.BlogRepository;
import com.codemusik.dao.TypeRepository;
import com.codemusik.po.Blog;
import com.codemusik.util.EntityUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BlogApplicationTests {

	@Autowired
	private BlogRepository blogRepository;

	@Autowired
	private TypeRepository typeRepository;

	@Test
	public void contextLoads() {
		Blog blog = blogRepository.findOne(2l);
		for (int i = 0; i < 10; i++) {
			long id = 20 * (i+1) + 1l;
			blog.setId(id);
			blogRepository.save(blog);
		}
	}

	@Test
	public void testAssociationQuery() {
		List<Object[]> objects = typeRepository.findListTop();

        List<TypeOrTagBlog> typeBlogList = EntityUtils.castEntity(objects,TypeOrTagBlog.class,new TypeOrTagBlog());
		for (TypeOrTagBlog typeBlog : typeBlogList) {
			System.out.println(typeBlog.toString());
		}
	}


}
