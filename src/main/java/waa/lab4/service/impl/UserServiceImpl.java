package waa.lab4.service.impl;

import org.springframework.stereotype.Service;
import waa.lab4.Aspects.ExecutionTime;
import waa.lab4.domain.dto.UserDto;
import waa.lab4.domain.entity.Post;
import waa.lab4.domain.entity.Users;
import waa.lab4.repository.PostRepository;
import waa.lab4.repository.UserRepository;
import waa.lab4.service.UserService;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final PostRepository postRepository;

   public UserServiceImpl(UserRepository userRepository,PostRepository postRepository){

       this.userRepository = userRepository;
         this.postRepository = postRepository;
    }

    @Override
    public void saveUser(UserDto userDto) {
       Users users = new Users();
       users.setName(userDto.getName());
       userRepository.save(users);
    }

    @Override
    @ExecutionTime
    public Users getUserById(long id) {
       return userRepository.findById(id).orElse(null);

    }
    @Override
    public List<UserDto> getAllUsers() {
        List<Users> users = userRepository.findAll();
        return users.stream()
                .map(user -> new UserDto(user.getId(), user.getName()))
                .collect(Collectors.toList());
    }

    @Override
    public List<Post> getAllPostsByUserId(long id) {
        Optional<Users> user = userRepository.findById(id);
        return user.map(Users::getPosts).orElse(null);
    }

    @Override
    public List<Users> getAllUsersWithMoreThanNPost(long n) {
        return null;
    }

    @Override
    public void deleteUserById(long id) {
        userRepository.deleteById(id);
    }


    @Override
    public List<Users> getAllUsersWithMoreThanOnePost() {
        return userRepository.getAllUsersWithMoreThanOnePost();
    }
}
