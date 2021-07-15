package com.employee.enums;

public enum CRUDEnum {

    NULL_COUNT(0,"crud 操作数目为0");

    private Integer value;

    private String describe;

    CRUDEnum(Integer value,String describe){
        this.value = value;
        this.describe = describe;
    }

    public Integer getValue() {
        return value;
    }

    public String getDescribe() {
        return describe;
    }
}
