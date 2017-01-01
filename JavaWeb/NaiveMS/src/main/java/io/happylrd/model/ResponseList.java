package io.happylrd.model;

public class ResponseList<T> {
    public final static int OK = 1, FAILED = 0, EMPTY = -1;
    public final static String OK_STR = "成功", FAILED_STR = "失败", EMPTY_STR = "数据为空";

    private int code;
    private String msg;
    private Object data;

    private int pageNum;
    private int pageSize;
    private int totalNum;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public int getPageNum() {
        return pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getTotalNum() {
        return totalNum;
    }

    public void setTotalNum(int totalNum) {
        this.totalNum = totalNum;
    }
}
