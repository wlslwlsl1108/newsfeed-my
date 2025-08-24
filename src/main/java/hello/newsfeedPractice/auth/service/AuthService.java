package hello.newsfeedPractice.auth.service;

import hello.newsfeedPractice.auth.dto.AuthRequest;
import hello.newsfeedPractice.auth.dto.SignResponse;
import hello.newsfeedPractice.common.config.PasswordEncoder;
import hello.newsfeedPractice.user.entity.User;
import hello.newsfeedPractice.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder; // 이거 주입안해주면 passwordEncoder 오류 발생

    // 회원가입 //
    public SignResponse save(AuthRequest authRequest) {
        // 사용중인 이메일로 가입 불가
        if (userRepository.existsByEmailAndDeletedFalse(authRequest.getEmail())
        ) {
            throw new IllegalArgumentException("해당 이메일은 이미 사용중입니다.");
        }
        // 탈퇴한 이메일로 가입 불가
        if (userRepository.existsByEmail(authRequest.getEmail())
        ) {
            throw new IllegalArgumentException("이미 탈퇴한 이메일입니다. 재가입 할 수 없습니다.");
        }

        // User 엔티티 작성안하면 오류
        String encodedPassword = passwordEncoder.encode(authRequest.getPassword());
        User user = new User(
                authRequest.getName(),
                authRequest.getEmail(),
                encodedPassword
        );
        userRepository.save(user);
        return new SignResponse(
                user.getId(),
                user.getUsername(),
                user.getEmail()
        );
    }

}
