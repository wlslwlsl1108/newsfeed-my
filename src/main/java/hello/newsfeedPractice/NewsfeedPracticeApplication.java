package hello.newsfeedPractice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// @EnableJpaAuditing      // JPA 에서 Auditing(감사) 기능 활성화 => createdAt, updatedAt 자동 관리
// -> 중복으로 사용 금지 => JpaConfig에 이미 적었음
@SpringBootApplication  // 스프링부트 시작 지점 알려줌
/* 1. @SpringBootConfiguration = @Configuration : 빈 등록 가능
   2. @EnableAutoConfiguration : 자동 설정 기능 활성화
   3. @ComponentScan : 현재 패키지/하위 패키지 스캔해서 Bean 등록
*/
public class NewsfeedPracticeApplication {

    public static void main(String[] args) {
        SpringApplication.run(NewsfeedPracticeApplication.class, args);
    }

}
