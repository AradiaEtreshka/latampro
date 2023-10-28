package com.ctf.latampro.service.Impl;

import com.ctf.latampro.repository.CategoryRepository;
import com.ctf.latampro.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;

    @Autowired
    public CategoryServiceImpl(CategoryRepository categoryRepository){
        this.categoryRepository = categoryRepository;
    }

}
