package waa.lab4.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import waa.lab4.domain.entity.User;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    @Query("select u from User u where size(u.posts) > 1")
    public List<User> getAllUsersWithMoreThanOnePost();

    public Optional<User> findByUsername(String username);
}
