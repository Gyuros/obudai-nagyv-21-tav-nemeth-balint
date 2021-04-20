package cookbook.service.transformer;

import cookbook.persistence.entity.EntityBase;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Transformer {

    @Autowired
    private ModelMapper modelMapper;

    public <TResult, TSource extends EntityBase> TResult transform(TSource source, Class<TResult> type) {
        return modelMapper.map(source, type);
    }
}
