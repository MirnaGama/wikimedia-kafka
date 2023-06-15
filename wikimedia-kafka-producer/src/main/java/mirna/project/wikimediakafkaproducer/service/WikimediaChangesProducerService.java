package mirna.project.wikimediakafkaproducer.service;

import java.net.URI;
import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.launchdarkly.eventsource.EventHandler;
import com.launchdarkly.eventsource.EventSource;

import mirna.project.wikimediakafka.constants.TopicNameConstants;
import mirna.project.wikimediakafka.constants.URLConstants;
import mirna.project.wikimediakafkaproducer.handler.WikimediaChangesHandler;

@Service
public class WikimediaChangesProducerService {

	private static final Logger _log = LoggerFactory.getLogger(WikimediaChangesProducerService.class);
	private KafkaTemplate<String, String> kafkaTemplate;
	
	public WikimediaChangesProducerService(KafkaTemplate<String, String> kafkaTemplate) {
		this.kafkaTemplate = kafkaTemplate;
	}
	
	public void sendMessage() throws InterruptedException {
		
		String topic = TopicNameConstants.TOPIC_WIKIMEDIA_RECENTCHANGE;
		
		// to read real time stream data from wikimedia
		EventHandler eventHandler = new WikimediaChangesHandler(
				kafkaTemplate, TopicNameConstants.TOPIC_WIKIMEDIA_RECENTCHANGE);
		
		EventSource.Builder builder = new EventSource.Builder(
				eventHandler, URI.create(URLConstants.URL_WIKIMEDIA_RECENTCHANGE));
		
		EventSource eventSource = builder.build();
		eventSource.start();
		
		TimeUnit.MINUTES.sleep(10);	
	}
}
