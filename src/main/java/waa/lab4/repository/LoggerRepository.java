package waa.lab4.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import waa.lab4.domain.entity.Logger;

@Repository
public interface LoggerRepository extends JpaRepository<Logger, Long> {
}
