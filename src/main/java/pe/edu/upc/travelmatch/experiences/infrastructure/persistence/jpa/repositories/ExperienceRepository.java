package pe.edu.upc.travelmatch.experiences.infrastructure.persistence.jpa.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.edu.upc.travelmatch.experiences.domain.model.aggregates.Experience;

@Repository
public interface ExperienceRepository extends JpaRepository<Experience, Long> {
}