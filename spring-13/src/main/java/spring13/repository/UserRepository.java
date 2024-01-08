package spring13.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import spring13.domain.User;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
