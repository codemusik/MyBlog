package com.codemusik.service;

import com.codemusik.NotFoundException;
import com.codemusik.dao.FlagRepository;
import com.codemusik.po.Flag;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class FlagServiceImpl implements FlagService{
    @Autowired
    private FlagRepository flagRepository;

    @Transactional
    @Override
    public Flag saveFlag(Flag flag) {
        return flagRepository.save(flag);
    }

    @Transactional
    @Override
    public Flag getFlag(Long id) {
        return flagRepository.findOne(id);
    }

    @Override
    public Flag getFlagByName(String name) {
        return flagRepository.findByName(name);
    }

    @Transactional
    @Override
    public Page<Flag> listFlag(Pageable pageable) {
        return flagRepository.findAll(pageable);
    }

    @Override
    public List<Flag> listFlag() {
        return flagRepository.findAll();
    }


    @Override
    public List<Flag> listFlagTop(Integer size) {
        Sort sort = new Sort(Sort.Direction.DESC,"blogs.size");
        Pageable pageable = new PageRequest(0,size,sort);
        return flagRepository.findTop(pageable);
    }


    @Transactional
    @Override
    public Flag updateFlag(Long id, Flag flag) {
        Flag t = flagRepository.findOne(id);
        if (t == null) {
            throw new NotFoundException("不存在该类型");
        }
        BeanUtils.copyProperties(flag,t);
        return flagRepository.save(t);
    }



    @Transactional
    @Override
    public void deleteFlag(Long id) {
        flagRepository.delete(id);
    }
}
