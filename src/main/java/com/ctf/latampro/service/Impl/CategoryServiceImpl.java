package com.ctf.latampro.service.Impl;

import com.ctf.latampro.exceptions.ResourceNotFoundException;
import com.ctf.latampro.model.dto.CategoryDTO;
import com.ctf.latampro.model.entity.Category;
import com.ctf.latampro.repository.CategoryRepository;
import com.ctf.latampro.service.CategoryService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.stream.Collectors;

@Service
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;
    private static final Logger logger = Logger.getLogger(CategoryServiceImpl.class);

    private final ObjectMapper objectMapper;

    @Autowired
    public CategoryServiceImpl(CategoryRepository categoryRepository, ObjectMapper objectMapper){
        this.categoryRepository = categoryRepository;
        this.objectMapper = objectMapper;
    }

    @Override
    public CategoryDTO create(CategoryDTO categoryDTO) {
        return this.save(categoryDTO);
    }

    public CategoryDTO save(CategoryDTO categoryDTO) {
        Category category = objectMapper.convertValue(categoryDTO, Category.class);
        category = categoryRepository.save(category);
        logger.info("Category with ID " + category.getId() + " created");
        return categoryDTO;
    }

    @Override
    public CategoryDTO read(Long id) throws ResourceNotFoundException {
        if(categoryRepository.findById(id).isEmpty())
            throw new ResourceNotFoundException("The category searched by id: "+id+" doesn't exist");
        logger.info("Category with ID "+id+" found");
        return objectMapper.convertValue(categoryRepository.findById(id), CategoryDTO.class);
    }

    @Override
    public CategoryDTO update(CategoryDTO categoryDTO) throws ResourceNotFoundException {
        if(this.read(categoryDTO.getId()) == null)
            throw new ResourceNotFoundException("The category searched by id "+categoryDTO.getId()+" doesn't exist");
        logger.info("Category with ID "+categoryDTO.getId()+" updated");
        return this.save(categoryDTO);
    }

    @Override
    public void delete(Long id) throws ResourceNotFoundException {
        if(this.read(id) == null)
            throw new ResourceNotFoundException("The category searched by id "+id+" doesn't exist");

        categoryRepository.deleteById(id);
        logger.info("Category with ID "+id+" deleted");
    }

    @Override
    public Set<CategoryDTO> getAll() throws ResourceNotFoundException {
        Set<Category> categories = (Set<Category>) categoryRepository.findAll();
        if(categories.isEmpty())
            throw new ResourceNotFoundException("There are no categories");
        logger.info("Categories found");
        return categories.stream()
                .map(category -> objectMapper.convertValue(category, CategoryDTO.class))
                .collect(Collectors.toSet());
    }

    @Override
    public CategoryDTO findById(Long id) throws ResourceNotFoundException {
        if(categoryRepository.findById(id).isEmpty())
            throw new ResourceNotFoundException("The category searched by id: "+id+" doesn't exist");
        logger.info("Category with "+id+" found");
        return objectMapper.convertValue(categoryRepository.findById(id), CategoryDTO.class);
    }
}
