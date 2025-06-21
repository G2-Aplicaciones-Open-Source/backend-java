package pe.edu.upc.travelmatch.experiences.interfaces.acl;

import org.springframework.stereotype.Service;
import pe.edu.upc.travelmatch.experiences.domain.model.aggregates.Experience;
import pe.edu.upc.travelmatch.experiences.domain.model.queries.GetExperienceByIdQuery;
import pe.edu.upc.travelmatch.experiences.domain.services.ExperienceQueryService;

import java.util.Optional;

@Service
public class ExperiencesContextFacade {

    private final ExperienceQueryService experienceQueryService;

    public ExperiencesContextFacade(ExperienceQueryService experienceQueryService) {
        this.experienceQueryService = experienceQueryService;
    }

    public Optional<Experience> fetchExperienceById(Long experienceId) {
        return experienceQueryService.handle(new GetExperienceByIdQuery(experienceId));
    }

    public boolean existsExperienceById(Long experienceId) {
        return fetchExperienceById(experienceId).isPresent();
    }

    public boolean isExperienceOwnedByAgency(Long experienceId, Long agencyId) {
        var experience = fetchExperienceById(experienceId);
        return experience.isPresent() && experience.get().getAgencyId().equals(agencyId);
    }
}