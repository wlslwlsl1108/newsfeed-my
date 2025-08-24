package hello.newsfeedPractice.common;

// 성공 응답 메세지 별도 관리
public enum ResponseMessage {
    SUCCESS_SIGNUP("회원가입 성공", 201);

    private final String message;
    private final int code;

    ResponseMessage(String message, int code) {
        this.message = message;
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public int getCode() {
        return code;
    }
}
