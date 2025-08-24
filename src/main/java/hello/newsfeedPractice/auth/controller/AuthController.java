package hello.newsfeedPractice.auth.controller;

import hello.newsfeedPractice.auth.dto.AuthRequest;
import hello.newsfeedPractice.auth.dto.AuthResponse;
import hello.newsfeedPractice.auth.dto.SignResponse;
import hello.newsfeedPractice.auth.service.AuthService;
import hello.newsfeedPractice.common.ResponseMessage;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController              // @Controller + @ResponseBody => API 응답은 무조건 JSON/XML 형태로 반환
 // 1. @Controller -> 컨트롤러 역할 표시
 // 2. @ResponseBody -> 리턴값을 JSON 응답 바디로 직렬화
@RequiredArgsConstructor     // final 또는 @NonNull 붙은 필드 대상 -> 자동으로 생성자 생성해줌
@RequestMapping("/auth")  // 공통경로 지정 ("/auth")
public class AuthController {

    private final AuthService authService;     // 서비스 의존성 주입 (생성자 자동 주입)

// 회원가입 //
@PostMapping("/signup")
public ResponseEntity<AuthResponse<SignResponse>> signup(
        @Valid @RequestBody AuthRequest authRequest
) {
    SignResponse result = authService.save(authRequest);

    return ResponseEntity.status(HttpStatus.CREATED)
            .body(AuthResponse.success(
                    ResponseMessage.SUCCESS_SIGNUP.getMessage(), result)
            );
}

}
