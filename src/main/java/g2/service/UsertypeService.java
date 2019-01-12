package g2.service;

import g2.mapper.UsertypeMapper;
import g2.model.Usertype;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsertypeService {
    private UsertypeMapper usertypeMapper;

    @Autowired
    public UsertypeService(UsertypeMapper usertypeMapper) {
        this.usertypeMapper = usertypeMapper;
    }

    public int insertType(Usertype usertype) {
        return usertypeMapper.insert(usertype);
    }

    public List<String> selectType() {
        return usertypeMapper.selectType();
    }

    public String selectByType(String type) {
        return usertypeMapper.selectByType(type);
    }
}