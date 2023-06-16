package mirna.project.wikimediakafkaconsumer.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import mirna.project.wikimediakafkaconsumer.entity.WikimediaRecentChange;

public interface WikimediaRecentChangeRepository extends JpaRepository<WikimediaRecentChange, Long> {

}
