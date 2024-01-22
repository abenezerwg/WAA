package waa.lab4.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import waa.lab4.domain.entity.Users;

import java.util.List;

public interface UserRepository extends JpaRepository<Users, Long> {

    @Query("select u from Users u where size(u.posts) > 1")
    public List<Users> getAllUsersWithMoreThanOnePost();
}
