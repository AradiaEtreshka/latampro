package com.ctf.latampro.controller;


import com.ctf.latampro.exceptions.ResourceNotFoundException;
import com.ctf.latampro.model.dto.CategoryDTO;
import com.ctf.latampro.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    CategoryService categoryService;

    @PostMapping("/create")
    public ResponseEntity<?> addCategory(@RequestBody CategoryDTO categoryDTO) {
        categoryService.create(categoryDTO);
        return ResponseEntity.ok("Category created");
    }

    @GetMapping("/read/{id}")

    public ResponseEntity<?> findCategory(@PathVariable("id") Long id) throws ResourceNotFoundException {
        CategoryDTO categoryDTOFound = categoryService.read(id);
        return ResponseEntity.ok(categoryDTOFound);
    }

    @GetMapping("/read/all")
    public ResponseEntity<?> readAllCategory() throws ResourceNotFoundException {
        return ResponseEntity.ok(categoryService.getAll());
    }

    @PutMapping("/update")
    public ResponseEntity<?> updateCategory(@RequestBody CategoryDTO categoryDTO) throws ResourceNotFoundException {
        categoryService.update(categoryDTO);
        return ResponseEntity.ok("Category updated");
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteCategory(@PathVariable("id") Long id) throws ResourceNotFoundException {
        categoryService.delete(id);
        return ResponseEntity.ok("Category Deleted");
    }


}
