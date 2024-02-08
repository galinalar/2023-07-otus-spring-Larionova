package spring1718.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import spring1718.domain.User;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
