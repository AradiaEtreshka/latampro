package com.ctf.latampro.service;


import com.ctf.latampro.exceptions.ResourceNotFoundException;
import com.ctf.latampro.model.dto.CategoryDTO;

import java.util.Set;

public interface CategoryService {


   CategoryDTO create(CategoryDTO categoryDTO);
   CategoryDTO read(Long id) throws ResourceNotFoundException;
   CategoryDTO update(CategoryDTO categoryDTO) throws ResourceNotFoundException;
   void delete(Long id) throws ResourceNotFoundException;
   Set<CategoryDTO> getAll() throws ResourceNotFoundException;

   CategoryDTO findById(Long id) throws ResourceNotFoundException;

}
