package SpringbootRefresher.SpringbootRefresher.product;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import SpringbootRefresher.SpringbootRefresher.product.dto.ProductRequest;
import SpringbootRefresher.SpringbootRefresher.product.dto.ProductResponse;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/v1/products")
@AllArgsConstructor
public class ProductController {

    private final ProductService productService;

    // Create Product
    @PostMapping
    public ResponseEntity<ProductResponse> createProduct(
            @Valid @RequestBody ProductRequest request) {

        ProductResponse createdProduct = productService.createProduct(request);

        return ResponseEntity.ok(createdProduct);
    }

    // Fetch All Products
    @GetMapping
    public ResponseEntity<List<ProductResponse>> fetchProducts() {

        List<ProductResponse> products = productService.fetchProducts();

        return ResponseEntity.ok(products);
    }

    // Fetch Single Product
    @GetMapping("/{id}")
    public ResponseEntity<ProductResponse> fetchProduct(
            @PathVariable Long id) {

        ProductResponse product = productService.fetchProduct(id);

        return ResponseEntity.ok(product);
    }

    // Full Update Product
    @PutMapping("/{id}")
    public ResponseEntity<ProductResponse> modifyProduct(
            @Valid @RequestBody ProductRequest request,
            @PathVariable Long id) {

        ProductResponse updatedProduct =
                productService.modifyProduct(request, id);

        return ResponseEntity.ok(updatedProduct);
    }

    // Partial Update Product
    @PatchMapping("/{id}")
    public ResponseEntity<ProductResponse> updateProduct(
            @RequestBody ProductRequest request,
            @PathVariable Long id) {

        ProductResponse updatedProduct =
                productService.updateProduct(id, request);

        return ResponseEntity.ok(updatedProduct);
    }

    // Delete Product
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteProduct(
            @PathVariable Long id) {

        productService.deleteProduct(id);

        return ResponseEntity.ok("Product deleted successfully");
    }
}