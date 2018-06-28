package springmybatis.filter;

import com.alibaba.druid.support.http.WebStatFilter;

import javax.servlet.annotation.WebInitParam;

/**
 * 数据源监控 Filter配置
 */
@WebInitParam(name="exclusions",
        value="*.js,*.gif,*.jpg,*.bmp,*.png,*.css,*.ico,/druid/*")//忽略资源})
public class DruidStatFilter extends WebStatFilter {
}
