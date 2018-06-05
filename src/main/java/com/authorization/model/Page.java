package com.authorization.model;

/**
 * @Author: zhouheng
 * @Created: with IntelliJ IDEA.
 * @Description: 分页信息
 * @Date: 2018-03-16
 * @Time: 10:39
 */
public class Page {

    private Integer start = 0;
    private Integer count = 5;
    private Integer last = 0;

    public Integer getStart() {
        return start;
    }

    public void setStart(Integer start) {
        this.start = start;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Integer getLast() {
        return last;
    }

    public void setLast(Integer last) {
        this.last = last;
    }

    public void calculateLast(Integer total) {

        if (0 == total % count && total > count) {

            last = total - count;
        } else if (0 != total && total > count) {
            last = total - total % count;
        } else {
            last = total;
        }
    }
}
