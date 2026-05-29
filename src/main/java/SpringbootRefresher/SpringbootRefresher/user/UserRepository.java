package SpringbootRefresher.SpringbootRefresher.user;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    // This interface will be automatically implemented by Spring Data JPA
}
