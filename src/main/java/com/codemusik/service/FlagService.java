package com.codemusik.service;

import com.codemusik.po.Flag;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface FlagService {
    Flag saveFlag(Flag type);

    Flag getFlag(Long id);

    Flag getFlagByName(String name);

    Page<Flag> listFlag(Pageable pageable);

    List<Flag> listFlag();

    List<Flag> listFlagTop(Integer size);

    Flag updateFlag(Long id,Flag type);

    void deleteFlag(Long id);
}
