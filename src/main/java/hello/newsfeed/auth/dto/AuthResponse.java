package hello.newsfeed.auth.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter                                    // getter 메서드 자동 생성
@AllArgsConstructor                        // 모든 필드를 매개변수로 받는 생성자 자동 생성
@JsonInclude(JsonInclude.Include.NON_NULL) // JSON 직렬화(객체->JSON 변환) 시, NULL 필드 아예 제외
// 공통 응답을 위해 <T>제네릭 타입으로 변경 //
public class AuthResponse<T> {

    private boolean success;               // 성공, 실패 여부 -> true, false
    private String message;                // 응답 메세지
    private T data;                        // 실제 데이터
    private String errorCode;              // 에러 코드 (실패 시에만 응답)

    // 성공 응답 생성 //
    public static <T> AuthResponse<T> success(String message, T data) {
        return new AuthResponse<>(true, message, data, null);
    }

    // 실패 응답 생성 //
    public static <T> AuthResponse<T> error(String errorCode, String message) {
        return new AuthResponse<>(false, message, null, errorCode);
    }

}
