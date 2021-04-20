package cookbook.service.transformer;

import cookbook.persistence.entity.Cook;
import cookbook.persistence.repository.CookRepository;
import cookbook.service.dto.CookDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CookTransformer {

    @Autowired
    private CookRepository cookRepository;

    public CookDto toCookDto(Cook cook) {
        return new CookDto(cook. getId(), cook.getUsername(), cook.getPassword());
    }

    public Cook toCook(CookDto cook) {
        return cookRepository.findById(cook.getId()).get();
    }
}
