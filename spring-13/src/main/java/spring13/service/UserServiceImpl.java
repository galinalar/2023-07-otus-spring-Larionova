package spring13.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import spring13.domain.User;
import spring13.repository.UserRepository;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }
}