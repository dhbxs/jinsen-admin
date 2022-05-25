package top.dhbxs.jinsen.admin.util;

import java.io.Serializable;

/**
 * Json格式的数据进行响应
 */
public class JsonResult<E> implements Serializable {

    // 状态码
    private Integer state;

    // 描述信息
    private String message;

    // 返回泛型类型的数据data
    private E data;

    public JsonResult() {
    }

    // Json响应状态码方法
    public JsonResult(Integer state) {
        this.state = state;
    }

    // Json响应异常方法
    public JsonResult(Throwable e) {
        this.message = e.getMessage();
    }

    // Json响应状态码和数据方法
    public JsonResult(Integer state, E data) {
        this.state = state;
        this.data = data;
    }

    // getState方法
    public Integer getState() {
        return state;
    }

    // setState方法
    public void setState(Integer state) {
        this.state = state;
    }

    // getMessage方法
    public String getMessage() {
        return message;
    }

    // setMessage方法
    public void setMessage(String message) {
        this.message = message;
    }

    // getData方法 泛型
    public E getData() {
        return data;
    }

    // setData方法
    public void setData(E data) {
        this.data = data;
    }
}
