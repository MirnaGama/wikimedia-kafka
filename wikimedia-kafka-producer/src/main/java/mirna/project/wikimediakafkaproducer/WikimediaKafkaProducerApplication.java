package mirna.project.wikimediakafkaproducer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import mirna.project.wikimediakafkaproducer.service.WikimediaChangesProducerService;

@SpringBootApplication
public class WikimediaKafkaProducerApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(WikimediaKafkaProducerApplication.class, args);
	}

	@Autowired
	private WikimediaChangesProducerService _wikimediaChangesProducerService;
	
	@Override
	public void run(String... args) throws Exception {
		_wikimediaChangesProducerService.sendMessage();
	}

}
