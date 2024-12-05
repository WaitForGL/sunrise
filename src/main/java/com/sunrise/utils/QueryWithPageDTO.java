package com.sunrise.utils;

import lombok.Data;
import org.apache.poi.ss.formula.functions.T;

import java.util.List;

@Data
public class QueryWithPageDTO {
    private Integer code;
    // 总条数
    private Long total;
    // 数据
    private List<T> list; //FirstPlanDTO

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }
}
