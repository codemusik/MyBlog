package com.codemusik.dao;

import com.codemusik.po.Type;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TypeRepository extends JpaRepository<Type,Long> {

    Type findByName(String name);

    @Query(value = "SELECT t.id,t.name,count(b.id) as blog_number FROM t_type t LEFT JOIN t_blog b ON t.id = b.type_id WHERE b.published = true GROUP BY t.id ORDER BY blog_number DESC", nativeQuery = true)
    List<Object[]> findListTop();
}
