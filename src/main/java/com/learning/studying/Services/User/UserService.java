package com.learning.studying.Services.User;

import com.learning.studying.Models.User;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
public interface UserService {
    User save(User user);
    User view(Long id);
    List<User>all();
    User update(Long id, User user);
    User delete(Long id);
}
