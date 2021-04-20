package cookbook.service.cook;

import cookbook.persistence.repository.CookRepository;
import cookbook.service.CookbookBaseService;
import cookbook.service.CookbookObserverBaseService;
import cookbook.service.ObserverBaseService;
import cookbook.service.dto.CookResult;
import cookbook.service.transformer.Transformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class CookbookCookService extends CookbookObserverBaseService implements CookService {

    @Autowired
    private CookRepository cookRepository;

    @Autowired
    private Transformer transformer;

    private CookResult currentUser;

    @Override
    public void logout() throws IOException {
        updateObservables();
        currentUser = null;
    }

    @Override
    public boolean isLoggedIn() {
        return currentUser != null;
    }

    @Override
    public CookResult getCurrentUser() {
        return currentUser;
    }

    @Override
    public boolean authenticate(CookResult user) {
        var cook = cookRepository.findByUsernameAndPassword(user.getUsername(), user.getPassword());

        if(cook != null)
            currentUser = transformer.transform(cook, CookResult.class);

        return cook != null;
    }
}
