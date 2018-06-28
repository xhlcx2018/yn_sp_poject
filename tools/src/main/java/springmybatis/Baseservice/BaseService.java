package springmybatis.Baseservice;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

//import org.springframework.data.domain.Page; 分页

public abstract class BaseService<T>{
    //注入Mapper<T>
    @Autowired
    private Mapper<T> mapper;

    /**
     * 根据id查询数据
     *
     * @param id
     * @return
     */
    @Transactional(value = "JpaTransactionManager")
    public T selectByPrimaryKey(Long id) {
        return mapper.selectByPrimaryKey(id);
    }

    /**
     * 查询所有数据
     *
     * @return
     */
    @Transactional(value = "JpaTransactionManager")
    public List<T> selectAll() {
        return mapper.selectAll();
    }

    /**
     * 根据条件查询一条数据，如果有多条数据会抛出异常
     *
     * @param record
     * @return
     */
    @Transactional(value = "JpaTransactionManager")
    public T selectOne(T record) {
        return mapper.selectOne(record);
    }

    /**
     * 根据条件查询数据列表
     *
     * @param record
     * @return
     */
    @Transactional(value = "JpaTransactionManager")
    public List<T> selectListByWhere(T record) {
            return mapper.select(record);
    }

    /**
     * @param pageNum
     * @param pageSize
     * @param record
     * @return
     */
    @Transactional(value = "JpaTransactionManager")
     public PageInfo<T> selectPageListByWhere(Integer pageNum,Integer pageSize, T record) {
        PageHelper.startPage(pageNum,pageSize);
        List<T> list = this.selectListByWhere(record);
        PageInfo<T> p=new PageInfo<T>(list);
        return p;
    }

    /**
     *
     *  分页未写完
     * @return
     */
   /* @Transactional(value = "JpaTransactionManager")
    public org.springframework.data.domain.Page<T> queryPageListByWhere(T record) {
        // 设置分页条件
        List<T> list = this.selectListByWhere(record);
        return  new org.springframework.data.domain.PageImpl<T>(list);
    }*/
    /**
     * 新增数据，返回成功的条数
     *
     * @param record
     * @return
     */
    @Transactional(value = "JpaTransactionManager")
    public Integer save(T record) {
        return mapper.insert(record);
    }

    /**
     * 新增数据，使用不为null的字段，返回成功的条数
     *
     * @param record
     * @return
     */
    @Transactional(value = "JpaTransactionManager")
    public Integer saveSelective(T record) {
        return mapper.insertSelective(record);
    }

    /**
     * 修改数据，返回成功的条数
     *
     * @param record
     * @return
     */
    @Transactional(value = "JpaTransactionManager")
    public Integer updateByPrimaryKey(T record) {
        return mapper.updateByPrimaryKey(record);
    }

    /**
     * 修改数据，使用不为null的字段，返回成功的条数
     *
     * @param record
     * @return
     */
    @Transactional(value = "JpaTransactionManager")
    public Integer updateSelective(T record) {
        return mapper.updateByPrimaryKeySelective(record);
    }

    /**
     * 根据id删除数据
     *
     * @param id
     * @return
     */
    @Transactional(value = "JpaTransactionManager")
    public Integer deleteByPrimaryKey(Long id) {
        return mapper.deleteByPrimaryKey(id);
    }

    /**
     * 批量删除
     * @param clazz
     * @param property
     * @param values
     * @return
     */
    @Transactional(value = "JpaTransactionManager")
    public Integer deleteByIds(Class<T> clazz, String property, List<Object> values) {
        Example example = new Example(clazz);
        example.createCriteria().andIn(property, values);
        return mapper.deleteByExample(example);
    }

    /**
     * 根据条件做删除
     *
     * @param record
     * @return
     */
    @Transactional(value = "JpaTransactionManager")
    public Integer deleteByWhere(T record) {
        return mapper.delete(record);
    }

}
