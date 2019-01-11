package g2.service;

import g2.mapper.StuffMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StuffService {
    private final
    StuffMapper stuffMapper;

    @Autowired
    public StuffService(StuffMapper stuffMapper) {
        this.stuffMapper = stuffMapper;
    }
    
}
