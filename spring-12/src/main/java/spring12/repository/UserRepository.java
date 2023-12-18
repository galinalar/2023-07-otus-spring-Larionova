package spring12.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import spring12.domain.User;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
