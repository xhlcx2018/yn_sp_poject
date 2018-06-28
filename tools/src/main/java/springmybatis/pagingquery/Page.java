package springmybatis.pagingquery;

import java.util.List;

public class Page<T> extends ImmutablePage<T> implements IMutablePage<T> {

    public static <E> Page<E> copyFrom(PageInfo<E> page) {
        Page<E> result = new Page();
        result.setDataCountInOnePage(page.getDataCountInOnePage());
        result.setCurrentPageNo(page.getCurrentPageNo());
        result.setTotalDataCount(page.getTotalDataCount());
        result.setData(page.getData());
        return result;
    }

    public Page() {
    }

    public Page(long currentPageNo, long totalCount, int limitPerPage, List<T> data) {
        super(currentPageNo, totalCount, limitPerPage, data);
    }

    public void setDataCountInOnePage(int dataCountInOnePage) {
        this.dataCountInOnePage = dataCountInOnePage;
    }

    public void setCurrentPageNo(long currentPageNo) {
        this.currentPageNo = currentPageNo;
    }

    public void setData(List<T> data) {
        this.data = data;
    }

    public void setTotalDataCount(long totalDataCount) {
        this.totalDataCount = totalDataCount;
    }
}
