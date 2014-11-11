package nl.ing.ivr.dialogue.controller;

import nl.ing.ivr.dialogue.domain.Channel;
import nl.ing.ivr.dialogue.domain.DialogueRequest;
import nl.ing.ivr.dialogue.domain.DialogueResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;
import com.sun.jersey.api.json.JSONConfiguration;

@Controller
public class AnswerController { // extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2788391487114406955L;

	// should be String[] textFromSpeech
	//@RequestMapping("/answer")
	public DialogueResponse getRemoteAnswer(final String textFromSpeech, final String URL) {

		DialogueResponse output = null;
		try {
			//DialogueRequest qRequest = new DialogueRequest(textFromSpeech,
				//	Channel.POTS);

			ClientConfig clientConfig = new DefaultClientConfig();
			clientConfig.getFeatures().put(
					JSONConfiguration.FEATURE_POJO_MAPPING, Boolean.TRUE);
			Client client = Client.create(clientConfig);
			WebResource webResource = client
					.resource(URL
							+ textFromSpeech);
			// http://localhost:8080/answer?query=rente&channel=POTS
			// https://asking.herokuapp.com/answer?query=pas%20gevonden
			DialogueResponse response = webResource.accept("application/json")			
					.get(DialogueResponse.class);
			/*
			if (response.getStatus() != 200) {
				throw new RuntimeException("Failed : HTTP error code : "
						+ response.getStatus());
			}*/

			// output = response.getEntity(String.class);

			//output = response.getEntity(DialogueResponse.class);

			System.out.println("Server response .... \n");

			System.out.println(response.toString());
			//System.out.println(output);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return output;

	}

}
