//package likelion13th.blog.config;
//
//import com.theokanning.openai.service.OpenAiService;
////import lombok.Value;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.beans.factory.annotation.Value;
//
//@Configuration
//public class OpenAIConfig {
//
//    //application.yml파일에 설정된 openai.api.key값을 openaikey필드에 주입
//    @Value("${openai.api.key}")
//    private String openaikey;
//
//    //OpenAiService 인스턴스를 생성하고 openaikey를 사용해서 초기화한다.
//    @Bean
//    public OpenAiService openAiService(){
//        return new OpenAiService(openaikey);
//    }
//}
