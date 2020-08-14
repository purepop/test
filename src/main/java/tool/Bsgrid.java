package tool;

import java.util.List;

public class Bsgrid<T> {
    //MVCExam.VO
    /// <summary>
    /// 成功否
    /// </summary>
    private Boolean success;
    /// <summary>
    /// 总行数
    /// </summary>
    private int totalRows;
    /// <summary>
    /// 当前页面
    /// </summary>
    private int curPage;
    /// <summary>
    /// 数据
    /// </summary>
    private List<T> data;

    public Boolean getSuccess() {
        return success;
    }
    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public int getTotalRows() {
        return totalRows;
    }
    public void setTotalRows(int totalRows) {
        this.totalRows = totalRows;
    }

    public int getCurPage() {
        return curPage;
    }
    public void setCurPage(int curPage) {
        this.curPage = curPage;
    }

    public List<T> getData() {
        return data;
    }
    public void setData(List<T> data) {
        this.data = data;
    }
}