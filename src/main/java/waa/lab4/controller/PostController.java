package waa.lab4.controller;

import org.springframework.web.bind.annotation.*;
import waa.lab4.domain.dto.CreatePostDto;
import waa.lab4.domain.dto.PostDto;
import waa.lab4.service.PostService;

import java.util.List;

@RestController
@RequestMapping("/posts")

public class PostController {


    private final PostService postService;

    PostController(PostService postService){
        this.postService = postService;
    }


    @GetMapping
    public List<PostDto> getAllPosts() {
        List<PostDto> postDtos = postService.getAllPosts();
        return postDtos;
    }

    @GetMapping("/{id}")
    public PostDto getPostById(@PathVariable long id) {
        return postService.getPostById(id);
    }

    @PostMapping("/{userId}")
    public void createPost(@RequestBody CreatePostDto createPostDto, @PathVariable long userId) {
        postService.savePost(createPostDto,userId);
    }

    @GetMapping("/title/{title}")
    public List<PostDto> getAllPostsByTitle(@PathVariable String title) {
        return postService.getAllPostsByTitle(title);
    }
}
