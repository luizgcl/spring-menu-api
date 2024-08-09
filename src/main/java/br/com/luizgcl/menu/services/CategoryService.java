package br.com.luizgcl.menu.services;

import br.com.luizgcl.menu.dtos.category.CreateCategoryDTO;
import br.com.luizgcl.menu.dtos.category.ResponseCategoryDTO;
import br.com.luizgcl.menu.entities.Category;
import br.com.luizgcl.menu.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryService {

    private final CategoryRepository categoryRepository;

    public ResponseCategoryDTO createCategory(CreateCategoryDTO createCategoryDTO) {
        var category = new Category();

        category.setName(createCategoryDTO.name());
        category.setDescription(createCategoryDTO.description());
        category.setSlug(createCategoryDTO.slug());

        this.categoryRepository.save(category);

        return new ResponseCategoryDTO(
                category.getName(),
                category.getSlug(),
                category.getCreatedAt()
        );
    }

    public List<ResponseCategoryDTO> listCategories() {
        var categories = this.categoryRepository.findAll();

        return categories.stream().map(category -> new ResponseCategoryDTO(
                category.getName(),
                category.getSlug(),
                category.getCreatedAt()
        )).toList();
    }

    public Category findCategoryById(Long id) {
        return this.categoryRepository.findById(id).orElseThrow();
    }
}
