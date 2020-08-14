package tool;

public class BsgridPage {
    private int pageSize;//页面大小 类的属性
    private int curPage;//当前页
    private String sortName;//排序属性name
    private String sortOrder;//排序方向

    public int getPageSize() {
        return pageSize;
    }
    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getCurPage() {
        return curPage;
    }
    public void setCurPage(int curPage) {
        this.curPage = curPage;
    }

    public String getSortName() {
        return sortName;
    }
    public void setSortName(String sortName) {
        this.sortName = sortName;
    }

    public String getSortOrder() {
        return sortOrder;
    }
    public void setSortOrder(String sortOrder) {
        this.sortOrder = sortOrder;
    }
    /// <summary>
    /// 分页开始序号
    /// </summary>
    /// <returns></returns>
    public int GetStartIndex()//分页开始序号
    {
        return (curPage - 1) * pageSize;
    }
    /// <summary>
    /// 分页结束序号
    /// </summary>
    /// <returns></returns>
    public int GetEndIndex()// 分页结束序号
    {
        return curPage * pageSize - 1;
    }
}