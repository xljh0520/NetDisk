package cn.milkyship.backend.dao;

import cn.milkyship.backend.model.user.Group;
import cn.milkyship.backend.model.user.SimpleUser;
import cn.milkyship.backend.model.user.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component
public interface UserDao {
    public String add(SimpleUser simpleUser);
    public String add(Group group);
}
