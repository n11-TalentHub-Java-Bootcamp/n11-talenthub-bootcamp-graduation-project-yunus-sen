package com.yunussen.graduation.model.response.base;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
public class ResponseDataModel<T> extends BaseReponseModel{
    private T data;

    public ResponseDataModel(T data,OperationName operationName,OperationResult operationResult){
        super(operationName,operationResult);
        this.data=data;
    }
}
