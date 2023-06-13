package mirna.project.wikimediakafkaproducer.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

import mirna.project.wikimediakafkaproducer.constants.TopicNameConstants;

@Configuration
public class KafkaTopicConfiguration {

	@Bean
	public NewTopic buildRecentChangeTopic() {
		return TopicBuilder.name(TopicNameConstants.TOPIC_WIKIMEDIA_RECENTCHANGE)
				.build();
	}
}
