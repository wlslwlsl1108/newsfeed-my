package hello.newsfeedPractice.auth.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Getter;

@Getter
public class AuthRequest {

    // @NotEmpty -> application 에서 @EnableJpaAuditing 기입하면 클래스 연결 가능
    @NotEmpty(message = "이름은 필수입니다. 이름을 입력해주세요.")
    private String name;

    @NotEmpty(message = "이메일은 필수입니다. 이메일을 입력해주세요.")
    @Email(message = "이메일 형식이 올바르지 않습니다.")
    private String email;

    @NotEmpty(message = "비밀번호는 필수입니다. 비밀번호를 입력해주세요.")
    @Size(min = 8, message = "비밀번호는 8글자 이상이어야 합니다.")
    @Pattern(
            regexp = "^(?=\\S+$)(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*\\p{Punct}).*$",
            message = "비밀번호는 대/소문자, 숫자, 특수문자를 포함하여야 합니다.(공백금지)"
    )
    private String password;
}

/*  [regexp]

       - ^ : 문자열 시작 고정
       - (?=\\s+$) : 띄어쓰기 금지
       - (?=.*[a-z]) : 소문자 1개 이상
       - (?=.*[A-Z]) : 대문자 1개 이상
       - (?=.*\\d) : 숫자 1개 이상
       - (?=.*\\p{Punct}) : 특수문자 1개 이상
       - .* : 문자열 자체를 실제로 매치하는 역할
       - $ : 문자열 끝 고정

       -\s : 공백이 아닌 문자
       -\s + $ : 전체 문자열이 공백이 아닌 문자로 구성
 */