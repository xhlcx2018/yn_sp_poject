package springmybatis.pagingquery;

import java.util.List;

public interface IMutablePage<T> extends PageInfo<T> {

    void setDataCountInOnePage(int var1);

    void setCurrentPageNo(long var1);

    void setData(List<T> var1);

    void setTotalDataCount(long var1);
}
