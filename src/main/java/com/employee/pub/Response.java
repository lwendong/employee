package com.employee.pub;

import com.employee.enums.ResponseEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Response<T> implements Serializable {

    private static final long serialVersionUID = 7544984171637585843L;

    private Boolean isSuccess;

    private Integer code;

    private T data;

    private String message;



    public static <T> Response<T> SUCCESS(T data,String message){
        return new Response<T>(ResponseEnum.SUCCESS.getSuccess(),ResponseEnum.SUCCESS.getCode(),data,message);
    }

    public static <T> Response<T> ERROR(String message){
        return new Response<T>(ResponseEnum.ERROR.getSuccess(), ResponseEnum.ERROR.getCode(),null,message);
    }
}
