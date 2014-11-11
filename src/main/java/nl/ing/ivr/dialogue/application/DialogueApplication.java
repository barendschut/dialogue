package nl.ing.ivr.dialogue.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@EnableWebMvc
@EnableAutoConfiguration
@ComponentScan(basePackages = "nl.ing.opendialogue")
public class DialogueApplication {

    public static void main(String[] args) {
        String webPort = System.getenv("PORT");
        if (webPort == null || webPort.isEmpty()) {
            webPort = "8090";
        }
        System.setProperty("server.port", webPort);
        SpringApplication.run(DialogueApplication.class, args);
    }
}
