package com.codemusik.service;

import com.codemusik.bo.TypeOrTagBlog;
import com.codemusik.po.Type;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface TypeService {

    Type saveType(Type type);

    Type getType(Long id);

    Type getTypeByName(String name);

    Page<Type> listType(Pageable pageable);

    List<Type> listType();

    List<TypeOrTagBlog> listTypeBlog();

    Type updateType(Long id,Type type);

    void deleteType(Long id);
}
