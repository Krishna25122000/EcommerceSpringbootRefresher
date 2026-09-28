package SpringbootRefresher.SpringbootRefresher.order;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import io.micrometer.common.lang.NonNull;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
    @NonNull
    List<Order> findByUserId(Long userId);
}