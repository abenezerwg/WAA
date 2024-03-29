package waa.lab4.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreatePostDto {

    private String title;
    private String content;
    private String author;

    // Constructors, getters, and setters
}
