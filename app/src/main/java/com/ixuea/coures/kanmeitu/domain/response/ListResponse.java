package com.ixuea.coures.kanmeitu.domain.response;

import java.util.List;

/**
 * Created by smile on 02/03/2019.
 */

public class ListResponse<T> {
    private List<T> data;

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }
}
