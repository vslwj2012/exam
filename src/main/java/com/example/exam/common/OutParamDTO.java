package com.example.exam.common;

public class OutParamDTO<T>  {

    /**
     * 是否成功
     */
    private Boolean success = true;
    /**
     * 结果代码
     */
    private String code;
    /**
     * 处理信息
     */
    private String message;
    /**
     * 业务数据
     */
    private T data;

    /**
     * 获取success
     *
     * @return success
     */
    public Boolean getSuccess() {
        return success;
    }

    /**
     * 设定success
     *
     * @param success success
     */
    public void setSuccess(Boolean success) {
        this.success = success;
    }

    /**
     * 获取code
     *
     * @return code
     */
    public String getCode() {
        return code;
    }

    /**
     * 设定code
     *
     * @param code code
     */
    public void setCode(String code) {
        this.code = code;
    }

    /**
     * 获取message
     *
     * @return message
     */
    public String getMessage() {
        return message;
    }

    /**
     * 设定message
     *
     * @param message message
     */
    public void setMessage(String message) {
        this.message = message;
    }

    /**
     * 获取data
     *
     * @return data
     */
    public T getData() {
        return data;
    }

    /**
     * 设定data
     *
     * @param data data
     */
    public void setData(T data) {
        this.data = data;
    }
}
