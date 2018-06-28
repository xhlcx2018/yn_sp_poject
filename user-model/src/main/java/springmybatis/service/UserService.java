package springmybatis.service;


import springmybatis.Baseservice.BaseService;
import springmybatis.dao.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import springmybatis.model.SystemUser;

@Service
public class UserService extends BaseService<SystemUser> {

    @Autowired
    private UserMapper userMapper;

    @Transactional(value = "transactionManager")
    public boolean login(SystemUser user)
    {
        if(user.getLoginName()!=null&&user.getLoginPassword()!=null)
        {
           if(super.selectOne(user)!=null)
           {
                return true;
           }
        }
        return false;
    }
}


