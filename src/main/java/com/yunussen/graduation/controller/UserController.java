package com.yunussen.graduation.controller;

import com.yunussen.graduation.model.request.UserCreateRequestModel;
import com.yunussen.graduation.model.request.UserUpdateRequestModel;
import com.yunussen.graduation.model.response.base.BaseReponseModel;
import com.yunussen.graduation.model.response.base.OperationName;
import com.yunussen.graduation.model.response.base.OperationResult;
import com.yunussen.graduation.model.response.base.ResponseDataModel;
import com.yunussen.graduation.service.UserService;
import com.yunussen.graduation.shared.dto.UserDto;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;

@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private UserService userService;

    @PostMapping
    public ResponseEntity<ResponseDataModel<UserDto>> create(@RequestBody @Valid UserCreateRequestModel model) {
        return ResponseEntity.ok(new ResponseDataModel(userService.save(modelMapper.map(model, UserDto.class)), OperationName.CREATE,OperationResult.SUCCESS));
    }

    @DeleteMapping("/{publicId}")
    public ResponseEntity<BaseReponseModel> delete(@PathVariable @NotBlank String publicId){
        userService.delete(publicId);
        return ResponseEntity.ok(new BaseReponseModel(OperationName.DELETE,OperationResult.SUCCESS));
    }

    @PutMapping("/{publicId}")
    public ResponseEntity<ResponseDataModel<UserDto>> update(@PathVariable @NotBlank String publicId, @RequestBody @Valid UserUpdateRequestModel model){
        return ResponseEntity.ok(new ResponseDataModel(userService.update(publicId,modelMapper.map(model,UserDto.class)),OperationName.UPDATE,OperationResult.SUCCESS));
    }
}
