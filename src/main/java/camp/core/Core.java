package camp.core;

import camp.db.IObjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Core implements ICore{
    @Autowired
private IObjectRepository objectRepository;
    @Override
    public void start() {
        objectRepository.ObjectRepository();
        objectRepository.drawHashCheck();
    }
}
