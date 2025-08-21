package hello.newsfeed.auth.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter                                    // getter 메서드 자동 생성
@AllArgsConstructor                        // 모든 필드를 매개변수로 받는 생성자 자동 생성
@JsonInclude(JsonInclude.Include.NON_NULL) // JSON 직렬화(객체->JSON 변환) 시, NULL 필드 아예 제외
// <T> -> 실제 데이터
// 비밀번호는 보안상 응답하면 안됨
public class SignResponse {

    private final Long id;
    private final String name;
    private final String email;
}
