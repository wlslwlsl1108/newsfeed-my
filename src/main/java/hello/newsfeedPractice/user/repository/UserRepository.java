package hello.newsfeedPractice.user.repository;

import hello.newsfeedPractice.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

    boolean existsByEmailAndDeletedFalse(String email);

    boolean existsByEmail(String email);

}
