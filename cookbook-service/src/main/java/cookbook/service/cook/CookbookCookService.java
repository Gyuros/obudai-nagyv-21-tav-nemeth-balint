package cookbook.service.cook;

import cookbook.persistence.repository.CookRepository;
import cookbook.service.dto.CookDto;
import cookbook.service.transformer.CookTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class CookbookCookService implements CookService {

    @Autowired
    private CookRepository cookRepository;

    @Autowired
    private CookTransformer transformer;

    private CookDto currentUser;

    @Override
    public void logout() throws IOException {
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
            currentUser = transformer.transform(cook);

        return cook != null;
    }
}
