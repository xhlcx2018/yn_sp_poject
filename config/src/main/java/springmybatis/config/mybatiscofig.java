package springmybatis.config;


import com.github.pagehelper.PageHelper;
import com.mybatis.jpa.core.PersistentEnhancerScaner;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;



import java.util.Properties;

@Configuration
@AutoConfigureAfter(MybatisConfiguration.class)
public class mybatiscofig {


    @Bean
    public MapperScannerConfigurer MapperScannerConfigurer() {
        MapperScannerConfigurer mapperScannerConfigurer = new MapperScannerConfigurer();
        mapperScannerConfigurer.setBasePackage("springmybatis.dao");
        mapperScannerConfigurer.setSqlSessionFactoryBeanName("sqlSessionFactory");
        return mapperScannerConfigurer;
    }

    @Bean
    public tk.mybatis.spring.mapper.MapperScannerConfigurer tkMapperScannerConfigurer( ){
        tk.mybatis.spring.mapper.MapperScannerConfigurer tkmapperScannerConfigurer = new tk.mybatis.spring.mapper.MapperScannerConfigurer();
        tkmapperScannerConfigurer.setBasePackage("springmybatis.dao");
        tkmapperScannerConfigurer.setSqlSessionFactoryBeanName("sqlSessionFactory");
        return tkmapperScannerConfigurer;
    }

    @Bean
    public PersistentEnhancerScaner persistentEnhancerScaner(SqlSessionFactory sqlSessionFactory)
    {
        PersistentEnhancerScaner persistent = new PersistentEnhancerScaner();
        persistent.setSqlSessionFactory(sqlSessionFactory);;
        persistent.setEntityPackage("springmybatis.model");
        persistent.setMapperPackage("springmybatis.dao");
        return persistent;
    }
    @Bean
    public JpaVendorAdapter jpaVendorAdapter(){
        HibernateJpaVendorAdapter adapter = new HibernateJpaVendorAdapter();
        adapter.setDatabase(Database.POSTGRESQL);
        adapter.setShowSql(true);
        adapter.setGenerateDdl(false);//设置是否自动创建表
        adapter.setDatabasePlatform("org.hibernate.dialect.MySQL5Dialect");
        return adapter;
    }
}
