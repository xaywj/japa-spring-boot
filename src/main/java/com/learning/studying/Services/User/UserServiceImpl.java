package com.learning.studying.Services.User;

import com.learning.studying.Models.User;
import com.learning.studying.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
   private final UserRepository userRepository;
    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<User> all() {
        return this.userRepository.findAll();
    }

    @Override
    public User save(User user) {
        return this.userRepository.save(user);
    }

    @Override
    public User view(Long id) {
        return this.userRepository.findById(id).orElse(null);
    }


    @Override
    public User update(Long id, User user) {
        Optional<User> optionalUser = this.userRepository.findById(id);
        if (optionalUser.isPresent()) {
            User existingUser = optionalUser.get();
            // Update the properties of the existing user with the new values
            existingUser.setName(user.getName());
            existingUser.setUsername(user.getUsername());
            existingUser.setPassword(user.getPassword());
            return this.userRepository.save(existingUser);
        } else {
            return null;
        }
    }

    @Override
    public User delete(Long id) {
        return null;
    }
}
