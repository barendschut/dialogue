package nl.ing.ivr.dialogue.application;

import nl.ing.ivr.dialogue.controller.AnswerController;

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

		AnswerController controller = new AnswerController();

		
		
		
		
		controller.getRemoteAnswer("pas%20gevonden", "http://asking.herokuapp.com/answer?query=");
		controller.getRemoteAnswer("rente", "http://asking.herokuapp.com/answer?query=");
		
		controller.getRemoteAnswer("", "http://asking.herokuapp.com/validate-card/card-number/1234/expiryDate/072017");
	}
}
