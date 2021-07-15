package com.employee.enums;

public enum ResponseEnum {

    SUCCESS(true,200,"成功"),
    ERROR(false,500,"错误");

    private Boolean isSuccess;

    private Integer code;

    private String message;

    ResponseEnum(Boolean flag,Integer code,String message){
        this.code = code;
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public Boolean getSuccess() {
        return isSuccess;
    }
}
