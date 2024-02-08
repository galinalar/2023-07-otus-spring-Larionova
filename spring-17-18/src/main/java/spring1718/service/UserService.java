package spring1718.service;

import spring1718.domain.User;

public interface UserService {
    User findByUsername(String username);
}
