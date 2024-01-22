package waa.lab4.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import waa.lab4.domain.CustomError;
import waa.lab4.domain.entity.Post;
import waa.lab4.domain.entity.Users;
import waa.lab4.domain.dto.UserDto;
import waa.lab4.service.UserService;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService){
        this.userService = userService;
    }

    @GetMapping
    public ResponseEntity<List<UserDto>> getAllUsers() {
        return ResponseEntity.ok(userService.getAllUsers());
    }

    @PostMapping
    public void createUser(@RequestBody UserDto userDto) {
        userService.saveUser(userDto);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Users> getUserById(@PathVariable Integer id) throws CustomError {
        return new ResponseEntity<>(userService.getUserById(id), HttpStatus.OK);
    }
    @GetMapping("/{id}/posts")
    public ResponseEntity<List<Post>> getAllPostsByUserId(@RequestParam long id) {
        return ResponseEntity.ok(userService.getAllPostsByUserId(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteUserById(@PathVariable Integer id) throws CustomError {
        userService.deleteUserById(id);
        return new ResponseEntity<>("User Deleted", HttpStatus.OK);
    }

}
