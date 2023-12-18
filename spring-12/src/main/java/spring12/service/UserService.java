package spring12.service;

import spring12.domain.User;

public interface UserService {
    User findByUsername(String username);
}
