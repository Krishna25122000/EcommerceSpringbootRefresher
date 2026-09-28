package SpringbootRefresher.SpringbootRefresher.product;

import java.util.List;

import SpringbootRefresher.SpringbootRefresher.product.dto.ProductRequest;
import SpringbootRefresher.SpringbootRefresher.product.dto.ProductResponse;

public interface ProductService {

    // Create Product
    ProductResponse createProduct(ProductRequest request);

    // Fetch All Products
    List<ProductResponse> fetchProducts();

    // Fetch Single Product
    ProductResponse fetchProduct(Long id);

    // Full Update Product (PUT)
    ProductResponse modifyProduct(ProductRequest request, Long id);

    // Partial Update Product (PATCH)
    ProductResponse updateProduct(Long id, ProductRequest request);

    // Delete Product
    void deleteProduct(Long id);
}