package spring13.service;

import spring13.domain.User;

public interface UserService {
    User findByUsername(String username);
}
