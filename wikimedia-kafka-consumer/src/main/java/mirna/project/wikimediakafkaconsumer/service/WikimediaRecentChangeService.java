package mirna.project.wikimediakafkaconsumer.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import mirna.project.wikimediakafka.constants.TopicNameConstants;
import mirna.project.wikimediakafkaconsumer.entity.WikimediaRecentChange;
import mirna.project.wikimediakafkaconsumer.repository.WikimediaRecentChangeRepository;


@Service
public class WikimediaRecentChangeService {

	private static final Logger _log = LoggerFactory.getLogger(WikimediaRecentChangeService.class);

	@Autowired
	private WikimediaRecentChangeRepository wikimediaRecentChangeRepository;
	
	@KafkaListener(
			topics = TopicNameConstants.TOPIC_WIKIMEDIA_RECENTCHANGE,
			groupId = "myGroup")
	public void consume(String eventMessage) {
		
		_log.info(String.format("Event message received -> %s", eventMessage));
		
		WikimediaRecentChange wikimediaRecentChange = new WikimediaRecentChange();
		wikimediaRecentChange.setEventData(eventMessage);
		
		wikimediaRecentChangeRepository.save(wikimediaRecentChange);
	}
}
