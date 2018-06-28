package springmybatis.dao;

import com.mybatis.jpa.annotation.MapperDefinition;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import springmybatis.model.Smodule;

import java.util.List;

//@Repository
@Mapper
@MapperDefinition(domainClass  = Smodule.class)
public interface ModuleMpper extends tk.mybatis.mapper.common.Mapper<Smodule> {

    @Select("select m.module_name  FROM s_system_user u," +
            "s_module m, b_quick_menu me WHERE u.id=me.user_id AND" +
            "  m.module_id=me.module_id AND u.id=1;")
     public List<String> getQuikMenu();

    @Select("SELECT m.module_name FROM S_MODULE m,\n" +
            "S_RESOURCE r,s_system_user u,s_user_role_relations ro\n" +
            "WHERE parent_module_id = #{parentId} AND u.id=ro.USER_ID AND\n" +
            "ro.ROLE_ID = r.role_id AND r.resource_id=m.module_id\n" +
            "AND u.login_name=#{username};")
     public List<String> listCountMenu(@Param("parentId") Integer parentId, @Param("username")String username);
}
