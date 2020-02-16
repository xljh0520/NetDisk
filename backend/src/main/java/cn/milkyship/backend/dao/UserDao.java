package cn.milkyship.backend.dao;

import cn.milkyship.backend.model.user.SimpleUser;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

@Mapper
@Component
public interface UserDao {
    
    public void add(SimpleUser simpleUser);
    
    public void del(String id);
    
    public void updateSimpleUser(SimpleUser simpleUser);
    
    public SimpleUser findSimpleUser(String UserId);
    
}
