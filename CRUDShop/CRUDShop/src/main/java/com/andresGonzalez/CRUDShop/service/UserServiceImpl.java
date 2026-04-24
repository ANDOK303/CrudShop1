package com.andresGonzalez.CRUDShop.service;

import com.andresGonzalez.CRUDShop.entity.User;
import com.andresGonzalez.CRUDShop.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<User> list() {
        return userRepository.findAll();
    }

    @Override
    public User getById(Integer id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User with ID not found: " + id));
    }

    @Override
    public User create(User user) {
        user.setUserId(null);
        return userRepository.save(user);
    }

    @Override
    public User update(Integer id, User user) {
        User existing = getById(id);

        existing.setFirstName(user.getFirstName());
        existing.setLastName(user.getLastName());
        existing.setAge(user.getAge());
        existing.setEmail(user.getEmail());

        return userRepository.save(existing);
    }

    @Override
    public void delete(Integer id) {
        if (!userRepository.existsById(id)) {
            throw new RuntimeException("User with ID not found: " + id);
        }
        userRepository.deleteById(id);
    }
}