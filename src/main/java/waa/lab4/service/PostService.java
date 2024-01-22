package waa.lab4.service;

import org.springframework.stereotype.Service;
import waa.lab4.domain.dto.CreatePostDto;
import waa.lab4.domain.dto.PostDto;

import java.util.List;

@Service
public interface PostService {
    public List<PostDto> getAllPosts();
     public PostDto getPostById(long id);
     public void savePost(CreatePostDto createPostDto, long id);
        public List<PostDto> getAllPostsByTitle(String title);


}
