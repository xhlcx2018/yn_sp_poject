package springmybatis.pagingquery;

import java.util.List;

public interface PageInfo<T>  {

    //总条数
    long getTotalDataCount();

    //总页数
    long getTotalPageCount();

    //页条数
    int getDataCountInOnePage();

    //开始页
    int getStartOfPage();

    //页数据
    List<T> getData();

    //当前页
    long getCurrentPageNo();

    //是否有下一页
    boolean hasNextPage();

    //是否有上一页
    boolean hasPreviousPage();


}
