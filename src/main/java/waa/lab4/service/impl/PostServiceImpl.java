package waa.lab4.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import waa.lab4.domain.entity.Post;
import waa.lab4.domain.dto.CreatePostDto;
import waa.lab4.domain.dto.PostDto;
import waa.lab4.domain.entity.Users;
import waa.lab4.repository.PostRepository;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import waa.lab4.repository.UserRepository;
import waa.lab4.service.PostService;

@Service
public class PostServiceImpl implements PostService {

    private final PostRepository postRepository;
    private final ModelMapper modelMapper;
    private final UserRepository userRepository;

    @Autowired
    public PostServiceImpl(PostRepository postRepository, ModelMapper modelMapper, UserRepository userRepository) {
        this.postRepository = postRepository;
        this.modelMapper = modelMapper;
        this.userRepository = userRepository;
    }

    public List<PostDto> getAllPosts() {
        List<Post> posts = postRepository.findAll();
        return posts.stream()
                .map(post -> modelMapper.map(post, PostDto.class))
                .collect(Collectors.toList());
    }

    public PostDto getPostById(long id) {
        Post post = postRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Post not found"));
        return (post != null) ? modelMapper.map(post, PostDto.class) : null;
    }

    public void savePost(CreatePostDto createPostDto, long id) {
        Post post = modelMapper.map(createPostDto, Post.class);
        Users user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found")); // Throw an exception if user not found
        post.setUsers(user);
        postRepository.save(post);
    }

    public List<PostDto> getAllPostsByTitle(String title) {
        List<Post> posts = postRepository.findByTitle(title);
        return posts.stream()
                .map(post -> modelMapper.map(post, PostDto.class))
                .collect(Collectors.toList());
    }
}


