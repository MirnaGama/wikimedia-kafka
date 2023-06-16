package mirna.project.wikimediakafkaconsumer.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

@Entity
@Table(name="WIKIMEDIA_RECENTCHANGE")
public class WikimediaRecentChange {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="WIKIMEDIA_RECENTCHANGE_ID")
	private Long id;
	
	@Lob
	@Column(name="EVENT_DATA") 
	private String eventData;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEventData() {
		return eventData;
	}

	public void setEventData(String eventData) {
		this.eventData = eventData;
	}
	
}
