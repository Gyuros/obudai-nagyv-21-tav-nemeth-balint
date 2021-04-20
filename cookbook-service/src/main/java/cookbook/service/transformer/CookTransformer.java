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

    public CookDto transform(Cook cook) {
        return new CookDto(cook.getUsername(), cook.getPassword());
    }

    public Cook transform(CookDto cook) {
        return cookRepository.findById(cook.getId()).get();
    }
}
