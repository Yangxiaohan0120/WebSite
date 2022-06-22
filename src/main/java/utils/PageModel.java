package utils;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Chris Yang
 * created 2022-06-22 15:40
 **/


// 分页模型对象

public class PageModel {
    private int page; // 页码
    private int totalPages; // 总页数
    private int rows; // 每页记录数
    private int totalRows; // 总记录数
    private int pageStartRow; // 当前页从第n行开始
    private int pageEndRow; // 当前页到第n行结束
    private boolean hasNextPage; // 是否存在下一页
    private boolean hasPreviousPage; // 是否存在上一页
    private List pageData; // 当前页面的数据

    public PageModel() {
    }

    public PageModel(List data, int page, int rows) {
        this.page = page;
        this.rows = rows;
        totalRows = data.size();
        // 整数相除只会得到整数部分
        totalPages = new Double(Math.ceil(totalRows / (rows * 1f))).intValue();

        pageStartRow = (page - 1) * rows;
        pageEndRow = page * rows;
        if(pageEndRow > totalRows){
            pageEndRow = totalRows;
        }
        pageData = data.subList(pageStartRow,pageEndRow);

        if(page > 1){
            hasPreviousPage = true;
        }else {
            hasPreviousPage = false;
        }

        if(page < totalPages){
            hasNextPage = true;
        }else {
            hasNextPage = false;
        }
    }

    public void setPage(int page) {
        this.page = page;
    }

    public void setTotalPages(int totalPages) {
        this.totalPages = totalPages;
    }

    public void setRows(int rows) {
        this.rows = rows;
    }

    public void setTotalRows(int totalRows) {
        this.totalRows = totalRows;
    }

    public void setPageStartRow(int pageStartRow) {
        this.pageStartRow = pageStartRow;
    }

    public void setPageEndRow(int pageEndRow) {
        this.pageEndRow = pageEndRow;
    }

    public void setHasNextPage(boolean hasNextPage) {
        this.hasNextPage = hasNextPage;
    }

    public void setHasPreviousPage(boolean hasPreviousPage) {
        this.hasPreviousPage = hasPreviousPage;
    }

    public void setPageData(List pageData) {
        this.pageData = pageData;
    }

    public int getPage() {
        return page;
    }

    public int getTotalPages() {
        return totalPages;
    }

    public int getRows() {
        return rows;
    }

    public int getTotalRows() {
        return totalRows;
    }

    public int getPageStartRow() {
        return pageStartRow;
    }

    public int getPageEndRow() {
        return pageEndRow;
    }

    public boolean isHasNextPage() {
        return hasNextPage;
    }

    public boolean isHasPreviousPage() {
        return hasPreviousPage;
    }

    public List getPageData() {
        return pageData;
    }

    public static void main(String[] args) {
        List sample = new ArrayList();
        for (int i = 0; i < 100; i++) {
            sample.add(i);
        }

        PageModel pageModel = new PageModel(sample,6,8);

        System.out.println(pageModel.getPageData());
        System.out.println(pageModel.getTotalPages());
        System.out.println(pageModel.getPageStartRow() + " : " + pageModel.getPageEndRow());

    }

}
