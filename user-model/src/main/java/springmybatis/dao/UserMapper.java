package springmybatis.dao;

import com.mybatis.jpa.annotation.MapperDefinition;
import springmybatis.model.SystemUser;
import org.apache.ibatis.annotations.Mapper;

//@Repository
@Mapper
@MapperDefinition(domainClass  = SystemUser.class)
public interface UserMapper extends tk.mybatis.mapper.common.Mapper<SystemUser> {
}
