package springmybatis.pagingquery;

import java.io.Serializable;
import java.util.Collections;
import java.util.List;

public class ImmutablePage<T> implements Serializable, PageInfo<T> {
    public static final long serialVersionUID = 1L;
    public static final int DEFAULT_DATA_SIZE_IN_ONE_PAGE = 20;
    protected int dataCountInOnePage;
    protected long currentPageNo;
    protected List<T> data;
    protected long totalDataCount;

    public ImmutablePage() {
        this(0L, 0L, 20, Collections.EMPTY_LIST);
    }

    public ImmutablePage(long currentPageNo, long totalCount, int limitPerPage, List<T> data) {
        this.dataCountInOnePage = 20;
        if (0 > limitPerPage) {
            throw new IllegalStateException("页面的数据大小不能为0！");
        } else {
            this.currentPageNo = currentPageNo;
            this.totalDataCount = totalCount;
            this.dataCountInOnePage = limitPerPage;
            this.data = data;
        }
    }

    public long getTotalDataCount() {
        return this.totalDataCount;
    }

    public long getTotalPageCount() {
        return this.totalDataCount % (long)this.dataCountInOnePage == 0L ? this.totalDataCount / (long)this.dataCountInOnePage : this.totalDataCount / (long)this.dataCountInOnePage + 1L;
    }

    public int getDataCountInOnePage() {
        return this.dataCountInOnePage;
    }

    public int getStartOfPage() {
        return getStartOfPage((int)this.getCurrentPageNo(), this.getDataCountInOnePage());
    }

    public List<T> getData() {
        return this.data;
    }

    public long getCurrentPageNo() {
        return this.currentPageNo;
    }

    public boolean hasNextPage() {
        return this.getCurrentPageNo() < this.getTotalPageCount() - 1L;
    }

    public boolean hasPreviousPage() {
        return this.getCurrentPageNo() > 0L;
    }

    public static int getStartOfPage(int pageNo) {
        return getStartOfPage(pageNo, 20);
    }

    public static int getStartOfPage(int pageNo, int pageSize) {
        if (0 > pageNo) {
            throw new IllegalArgumentException("页面索引不能小于0!");
        } else {
            return pageNo * pageSize;
        }
    }
}