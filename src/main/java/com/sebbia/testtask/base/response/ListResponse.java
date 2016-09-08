package com.sebbia.testtask.base.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;

import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.List;

public class ListResponse<T> extends SuccessResponse {

    private List<T> list;

    public ListResponse() {
    }

    public ListResponse(List<T> list) {
        this.list = list;
    }

    public ListResponse(Iterable<T> list) {
        ArrayList<T> l = new ArrayList<>();
        for (T o : list) {
            l.add(o);
        }
        this.list = l;
    }

    public <U> void fillWithDto(Class<T> dtoClass, Class<U> srcClass, Iterable<U> list) {
        try {
            Constructor<T> constructor = dtoClass.getConstructor(srcClass);
            this.list = new ArrayList<>();
            for (U o : list) {
                this.list.add(constructor.newInstance(o));
            }
        } catch (Exception e) {
            throw new RuntimeException("Cannot create list response with DTOs");
        }
    }

    static public <T, U> ListResponse<T> initWithDto(Class<T> dtoClass, Class<U> srcClass, Iterable<U> list) {
        ListResponse<T> res = new ListResponse<>();
        res.fillWithDto(dtoClass, srcClass, list);
        return res;
    }

    @JsonProperty(value = "list")
    @ApiModelProperty(value = "Список объектов", required = true)
    public List<T> getList() {
        return list;
    }
}
