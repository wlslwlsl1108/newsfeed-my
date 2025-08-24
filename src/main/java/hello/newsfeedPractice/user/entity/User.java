package hello.newsfeedPractice.user.entity;

import hello.newsfeedPractice.BaseEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "user", indexes = {
        @Index(name = "user_email", columnList = "email", unique = true)
})
public class User extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long id;

    @Column(length = 100, nullable = false, unique = true)
    private String email;

    @Column(length = 15, nullable = false)
    private String username;

    @Column(length = 100, nullable = false)
    private String password;

    @Column(name = "progileImage", length = 100)
    private  String profileImage;

    // 회원가입용 User 객체 생성 //
    public User(String username, String email, String password) {
        this.username = username;
        this.email = email;
        this.password = password;
    }

    private boolean deleted = false;

}
