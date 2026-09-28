package SpringbootRefresher.SpringbootRefresher.product;

import java.util.List;

import org.springframework.stereotype.Service;

import SpringbootRefresher.SpringbootRefresher.product.dto.ProductRequest;
import SpringbootRefresher.SpringbootRefresher.product.dto.ProductResponse;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@AllArgsConstructor
@Slf4j
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    // Create Product
    @Override
    public ProductResponse createProduct(ProductRequest request) {

        Product product = new Product();

        product.setName(request.getName());
        product.setDescription(request.getDescription());
        product.setPrice(request.getPrice());
        product.setStock(request.getStock());
        product.setCategory(request.getCategory());

        Product savedProduct = productRepository.save(product);

        log.info("Product created successfully: {}", savedProduct.getName());

        return mapToResponse(savedProduct);
    }

    // Fetch All Products
    @Override
    public List<ProductResponse> fetchProducts() {

        List<Product> products = productRepository.findAll();

        return products.stream()
                .map(this::mapToResponse)
                .toList();
    }

    // Fetch Single Product
    @Override
    public ProductResponse fetchProduct(Long id) {

        Product product = productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found"));

        return mapToResponse(product);
    }

    // Full Update Product (PUT)
    @Override
    public ProductResponse modifyProduct(ProductRequest request, Long id) {

        Product product = productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found"));

        product.setName(request.getName());
        product.setDescription(request.getDescription());
        product.setPrice(request.getPrice());
        product.setStock(request.getStock());
        product.setCategory(request.getCategory());

        Product updatedProduct = productRepository.save(product);

        log.info("Product updated successfully: {}", updatedProduct.getName());

        return mapToResponse(updatedProduct);
    }

    // Partial Update Product (PATCH)
    @Override
    public ProductResponse updateProduct(Long id, ProductRequest request) {

        Product product = productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found"));

        if (request.getName() != null)
            product.setName(request.getName());

        if (request.getDescription() != null)
            product.setDescription(request.getDescription());

        if (request.getPrice() != null)
            product.setPrice(request.getPrice());

        if (request.getStock() != null)
            product.setStock(request.getStock());

        if (request.getCategory() != null)
            product.setCategory(request.getCategory());

        Product updatedProduct = productRepository.save(product);

        log.info("Product partially updated: {}", updatedProduct.getName());

        return mapToResponse(updatedProduct);
    }

    // Delete Product
    @Override
    public void deleteProduct(Long id) {

        Product product = productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found"));

        productRepository.delete(product);

        log.info("Product deleted successfully: {}", product.getName());
    }

    // Helper Method
    private ProductResponse mapToResponse(Product product) {

        return new ProductResponse(
                product.getId(),
                product.getName(),
                product.getDescription(),
                product.getPrice(),
                product.getStock(),
                product.getCategory(),
                product.getCreatedAt(),
                product.getUpdatedAt());
    }
}