package pe.edu.upc.travelmatch.geolocation.infrastructure.persistence.jpa.repositories;

import org.springframework.stereotype.Repository;
import pe.edu.upc.travelmatch.experiences.domain.model.aggregates.Experience;
import pe.edu.upc.travelmatch.geolocation.domain.model.aggregates.Destination;
import pe.edu.upc.travelmatch.geolocation.domain.model.valueobjects.CityName;
import pe.edu.upc.travelmatch.profiles.domain.model.valueobjects.ExperienceId;

import java.util.List;

@Repository
public interface DestinationRepository {
    List<Experience> findByExperienceId(ExperienceId experienceId);
    boolean existsByName(String name);

    boolean existsById(Long aLong);

    void deleteById(Long aLong);

    boolean existsByFullName(Object fullName);

    void save(Destination destination);
}
