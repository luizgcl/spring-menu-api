package br.com.luizgcl.menu.services;

import br.com.luizgcl.menu.dtos.product.CreateProductDTO;
import br.com.luizgcl.menu.dtos.product.ResponseProductDTO;
import br.com.luizgcl.menu.entities.Product;
import br.com.luizgcl.menu.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;
    private final CategoryService categoryService;

    public ResponseProductDTO createProduct(CreateProductDTO createProductDTO) {
        var product = new Product();

        product.setName(createProductDTO.name());
        product.setSku(createProductDTO.sku());
        product.setSlug(createProductDTO.slug());
        product.setCost(createProductDTO.cost());
        product.setPrice(createProductDTO.price());

        var category = this.categoryService.findCategoryById(createProductDTO.categoryId().longValue());
        product.setCategory(category);

        this.productRepository.save(product);

        return new ResponseProductDTO(
                product.getName(),
                product.getSku(),
                product.getSlug(),
                product.getCost(),
                product.getPrice(),
                product.getCategory().getName(),
                product.getCreatedAt()
        );
    }

    public List<ResponseProductDTO> listProductsByCategoryId(Long categoryId) {
        return this.productRepository.findByCategoryId(categoryId)
                .stream().map(product -> new ResponseProductDTO(
                        product.getName(),
                        product.getSku(),
                        product.getSlug(),
                        product.getCost(),
                        product.getPrice(),
                        product.getCategory().getName(),
                        product.getCreatedAt()
                )).toList();
    }
}