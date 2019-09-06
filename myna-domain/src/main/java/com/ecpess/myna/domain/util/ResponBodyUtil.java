package com.ecpess.myna.domain.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.JSONSerializer;
import com.alibaba.fastjson.serializer.PropertyPreFilter;
import java.io.Serializable;
import java.util.List;

/**
 * @author caoqc
 * @Description:返回数据
 * @date 2019/7/31 11:11
 */
public class ResponBodyUtil<T> implements Serializable {

    private static final long serialVersionUID = -4521158458906059993L;
    private static final String SUCCESS = "success";
    private static final String FAIL = "fail";
    private static final String ERROR = "error";
    private static final String ERROR_MESSAGE = "系统异常，请稍后重试";


    private String code;
    private String message;
    private T data;

    public ResponBodyUtil() {
        this.code = FAIL;
        this.message = FAIL;
    }

    public ResponBodyUtil success(T data) {
        this.code = SUCCESS;
        this.message = SUCCESS;
        this.data = data;
        return this;
    }

    public ResponBodyUtil fail(String code, String message) {
        this.code = code;
        this.message = message;
        this.data = null;
        return this;
    }

    public ResponBodyUtil fail(String code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
        return this;
    }

    public ResponBodyUtil error() {
        this.code = ERROR;
        this.message = ERROR_MESSAGE;
        this.data = null;
        return this;
    }

    public ResponBodyUtil error(String message) {
        this.code = ERROR;
        this.message = message;
        this.data = null;
        return this;
    }

    @Override
    public String toString() {
        return JSON.toJSONString(this);
    }

    public String toStringFiltrate(List<String> names) {
        PropertyPreFilter propertyPreFilter = new PropertyPreFilter() {
            @Override
            public boolean apply(JSONSerializer jsonSerializer, Object o, String s) {
                if (names.stream().anyMatch(name -> name.equals(s))) {
                    return false;
                }
                return true;
            }
        };
        return JSON.toJSONString(this, propertyPreFilter);
    }

    public String toStringFiltrate() {
        PropertyPreFilter propertyPreFilter = new PropertyPreFilter() {
            @Override
            public boolean apply(JSONSerializer jsonSerializer, Object o, String s) {
                if ("createTime".equals(s) || "updateTime".equals(s) || "version".equals(s)) {
                    return false;
                }
                return true;
            }
        };
        return JSON.toJSONString(this, propertyPreFilter);
    }

    public String getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public T getData() {
        return data;
    }
}
