package cookbook.service;

import cookbook.domain.Identifiable;
import cookbook.persistence.Data;
import cookbook.util.DataParser;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public abstract class CookbookBaseService<T extends Identifiable> implements BaseService<T> {

    private String initFile;
    protected List<T> models;

    @Autowired
    protected DataParser<T> dataParser;

    @Autowired
    protected Data data;

    protected CookbookBaseService(String initFile) {
        this.models = new ArrayList<>();
        this.initFile = initFile;
    }

    public void init() throws IOException {
        String initData = data.read(initFile);
        models = dataParser.parse(initData);
    }

    public T findById(long id) {
        return models.stream()
                .filter(c -> c.getId() == id)
                .findFirst()
                .orElse(null);
    }

    public void update(Object observer) throws IOException {
        data.write(initFile, dataParser.toString(models));
    }
}
