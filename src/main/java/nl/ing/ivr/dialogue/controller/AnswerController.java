package nl.ing.ivr.dialogue.controller;

import javax.servlet.http.HttpServlet;

import nl.ing.ivr.dialogue.domain.Channel;
import nl.ing.ivr.dialogue.domain.QuestionRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;
import com.sun.jersey.api.json.JSONConfiguration;

@Controller
public class AnswerController extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2788391487114406955L;

	// should be String[] textFromSpeech
	@RequestMapping("/answer")
	public String getRemoteAnswer(String textFromSpeech) {

		String output = null;
		try {
			QuestionRequest qRequest = new QuestionRequest(textFromSpeech,
					Channel.POTS);

			ClientConfig clientConfig = new DefaultClientConfig();
			clientConfig.getFeatures().put(
					JSONConfiguration.FEATURE_POJO_MAPPING, Boolean.TRUE);
			Client client = Client.create(clientConfig);
			WebResource webResource = client
					.resource("http://localhost:8080/answer?query=rente&channel=POTS");
			ClientResponse response = webResource.accept("application/json")
					.type("application/json")
					.post(ClientResponse.class, qRequest);
			if (response.getStatus() != 200) {
				throw new RuntimeException("Failed : HTTP error code : "
						+ response.getStatus());
			}

			output = response.getEntity(String.class);

			System.out.println("Server response .... \n");

			System.out.println(output);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return output;

	}

}
