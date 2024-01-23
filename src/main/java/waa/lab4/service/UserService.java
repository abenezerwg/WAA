package waa.lab4.service;

import org.springframework.stereotype.Service;
import waa.lab4.domain.entity.Post;
import waa.lab4.domain.entity.User;
import waa.lab4.domain.dto.UserDto;

import java.util.List;

@Service
public interface UserService {
    public void saveUser(UserDto userDto);
    public User getUserById(long id);
    public List<UserDto> getAllUsers();
    public List<Post> getAllPostsByUserId(long id);
    public List<User> getAllUsersWithMoreThanNPost(long n);
    public List<User> getAllUsersWithMoreThanOnePost();
    public void deleteUserById(long id);

}
