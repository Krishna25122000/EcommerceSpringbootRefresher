
package SpringbootRefresher.SpringbootRefresher.cart;

import SpringbootRefresher.SpringbootRefresher.cart.dto.CartResponse;

public interface CartService {
    CartResponse addToCart(Long userId, Long productId, Integer quantity);
    CartResponse getCart(Long userId);
    void removeFromCart(Long userId, Long productId);
}