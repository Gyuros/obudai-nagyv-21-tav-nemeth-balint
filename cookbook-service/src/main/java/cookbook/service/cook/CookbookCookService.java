package cookbook.service.cook;

import cookbook.persistence.repository.CookRepository;
import cookbook.service.dto.CookDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class CookbookCookService extends CookbookObserverBaseService implements CookService {

    @Autowired
    private CookRepository cookRepository;

    @Autowired
    private Transformer transformer;

    private CookDto currentUser;

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
    public CookDto getCurrentUser() {
        return currentUser;
    }

    @Override
    public boolean authenticate(CookDto user) {
        var cook = cookRepository.findByUsernameAndPassword(user.getUsername(), user.getPassword());

        if(cook != null)
            currentUser = null; // cook;

        return cook != null;
    }
}
