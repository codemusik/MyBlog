package com.codemusik.dao;

import com.codemusik.po.Flag;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface FlagRepository extends JpaRepository<Flag,Long> {

    Flag findByName(String name);


    @Query("select t from Flag t")
    List<Flag> findTop(Pageable pageable);
}
