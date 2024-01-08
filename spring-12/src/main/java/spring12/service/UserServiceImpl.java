package spring12.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import spring12.domain.User;
import spring12.repository.UserRepository;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }
}