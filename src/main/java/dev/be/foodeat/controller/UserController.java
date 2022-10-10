package dev.be.foodeat.controller;

import dev.be.foodeat.dto.BmiDTO;
import dev.be.foodeat.dto.ResponseUserDTO;
import dev.be.foodeat.request.UserRequest;
import dev.be.foodeat.service.BMIService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final BMIService bmiService;
    @GetMapping("/user")
    public ResponseEntity<ResponseUserDTO> userInfo(UserRequest userRequest){
        try{
            BmiDTO bmiDTO = bmiService.getUserBMI(userRequest.getHeight(),userRequest.getWeight());
            ResponseUserDTO<BmiDTO> result = new ResponseUserDTO<>();
            result.setData(bmiDTO);

            return ResponseEntity.ok().body(result);

        }catch (Exception e){
            String error = e.getMessage();
            ResponseUserDTO<BmiDTO> result = new ResponseUserDTO<>();
            result.setError(error);

            return ResponseEntity.badRequest().body(result);
        }
    }
}
