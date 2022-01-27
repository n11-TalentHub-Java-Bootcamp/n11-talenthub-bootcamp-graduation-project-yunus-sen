package com.yunussen.graduation.model.response.base;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class BaseReponseModel {
    private OperationName operationName;
    private OperationResult operationResult;

    public BaseReponseModel(OperationName operationName,OperationResult operationResult){
        this.operationName=operationName;
        this.operationResult=operationResult;
    }
}
