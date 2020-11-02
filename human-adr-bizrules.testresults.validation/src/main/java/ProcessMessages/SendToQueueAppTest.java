package ProcessMessages;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jms.core.JmsTemplate;
import eu.europa.ema.phv.adr.tests.support.msgbuilder.*; 

/**
* To send the requested number of copies based on the requested template
* to the requested queue.
* 
* A prefix is also taken as parameter.
*
* @author  Unni Kannan (created by)
* @since 22 May 2019 (creation date)
*/
@SpringBootApplication
public class SendToQueueAppTest implements CommandLineRunner {

	 
	private static final Logger LOGGER = LoggerFactory.getLogger(SendToQueueAppTest.class);
	
	@Autowired
	private JmsTemplate jmsTemplate;
	
	private void sendToQueue(String filename, String path, String queue) throws IOException {
		String senderPartyName;
		String OSBCOMMUNITY;
		// Find sender party name
		if (path.startsWith("/HumanFunctionalTestData/")) {
			senderPartyName = "EV Human";
			OSBCOMMUNITY="HUMAN";

		} else {
			senderPartyName = "EV Veterinary Production";
			OSBCOMMUNITY="VET";
		}
		//senderPartyName = "EV Veterinary Production";
		LOGGER.info("Sending file {} with party name {}", filename, senderPartyName);
		
		MessageBuilder builder = new MessageBuilder();
		byte[] asBytes = builder.forPath(path)
			.encodedAs(StandardCharsets.UTF_8)
.withHeader("CoreId", filename).withHeader("ProductionFilename", filename).withHeader("ReceiverPartyName", senderPartyName).withHeader("MDN_DATE", new Long(System.currentTimeMillis()))
		
				.buildBytesPayload();
		// Send it ...
		this.jmsTemplate.send(queue, session -> builder.toMessage(session, asBytes));

	}
	 
	@Override
	public void run(String... args) throws Exception {
		LOGGER.info("Running with arguments: ");
			for (int i = 0; i < args.length; i++) {
				LOGGER.info("arg {}: {}", i, args[i]);
					}
						String path = args[0];
						String queue = args[1];
				
								int pos = path.lastIndexOf('/');
									String filename = path.substring(pos + 1);
										sendToQueue(filename, path, queue);
								}

	public void fun(String[] args) {
		SpringApplication.run(SendToQueueAppTest.class, args);
		LOGGER.info("Completed execution");
		//System.exit(0);
	}
	
}
	
