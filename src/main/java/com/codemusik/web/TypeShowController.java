package com.codemusik.web;

import com.codemusik.bo.TypeOrTagBlog;
import com.codemusik.service.BlogService;
import com.codemusik.service.TypeService;
import com.codemusik.vo.BlogQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;


@Controller
public class TypeShowController {

    @Autowired
    private TypeService typeService;

    @Autowired
    private BlogService blogService;

    @GetMapping("/types/{id}")
    public String types(@PageableDefault(size = 8, sort = {"updateTime"}, direction = Sort.Direction.DESC) Pageable pageable,
                        @PathVariable Long id, Model model) {
        List<TypeOrTagBlog> typeBlogs = typeService.listTypeBlog();
        if (id == -1) {
           id = typeBlogs.get(0).getId().longValue();
        }
        BlogQuery blogQuery = new BlogQuery();
        blogQuery.setTypeId(id);
        model.addAttribute("types", typeBlogs);
        model.addAttribute("page", blogService.listBlog(pageable, blogQuery,false));
        model.addAttribute("activeTypeId", id);
        return "types";
    }
}
