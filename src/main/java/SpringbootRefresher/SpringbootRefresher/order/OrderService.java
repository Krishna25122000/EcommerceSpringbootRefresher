package SpringbootRefresher.SpringbootRefresher.order;

import SpringbootRefresher.SpringbootRefresher.order.dto.OrderResponse;
import java.util.List;

public interface OrderService {
    OrderResponse placeOrder(Long userId);
    List<OrderResponse> getUserOrders(Long userId);
}