package waa.lab4.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import waa.lab4.domain.entity.Comment;

public interface CommentRepository extends JpaRepository<Comment, Long> {
}
