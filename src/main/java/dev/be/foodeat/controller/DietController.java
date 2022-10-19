package dev.be.foodeat.controller;

import dev.be.foodeat.dto.DietInfoDTO;
import dev.be.foodeat.dto.DietSearchDTO;
import dev.be.foodeat.dto.ResponseUserDTO;
import dev.be.foodeat.entity.Diet;
import dev.be.foodeat.repository.DietRepository;
import dev.be.foodeat.request.DietRequest;
import dev.be.foodeat.request.UserRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@RestController
@RequiredArgsConstructor
public class DietController {
    public final DietRepository dietRepository;


    @GetMapping("/recommend")
    //계산하기에 나오는 추천하기 목록
    //BMI를 받아서 상한, 하한 권장 칼로리를 계산하고 이를 바탕으로 뽑아옴(4개)
    public ResponseEntity<ResponseUserDTO> recommendDiet(@RequestParam double idealWeight) {
        double kcal = idealWeight * 30 / 3;
        List<Diet> tmp = dietRepository.findDietByKcalBetween(0,kcal); //아직 안고침
        Collections.shuffle(tmp);
        List<DietSearchDTO> map = tmp.stream().limit(4).map(t -> {
            List<String> collect = t.getDiet_list().stream().map(d -> d.getFood().getName()).collect(Collectors.toList());
            return new DietSearchDTO(t.getId(), t.getName(), collect);
        }).collect(Collectors.toList());

        ResponseUserDTO result = new ResponseUserDTO<>();
        result.setData(map);

        return ResponseEntity.ok().body(result);
    }

    //BMI 수치가 있을 경우 18미만이면 고열량위주로 보여주고 25이상이면 저열량위주로 정렬해서 검색결과를 보여줌
    //BMi 수치가 없을 경우는 정렬하지 않고 이름으로 검색해서 보여줌
    @GetMapping("/diet")
    public Page<DietSearchDTO> searchDiet(int page, int size, @RequestParam String name, @RequestParam(required = false) Double bmi){
        PageRequest pageRequest = PageRequest.of(page,size);

        if(bmi != null){
            if(bmi.doubleValue()<18){
                pageRequest = PageRequest.of(page,size, Sort.by(Sort.Direction.DESC,"kcal"));
            }
            else if (bmi.doubleValue()>=25) {
                pageRequest = PageRequest.of(page,size, Sort.by(Sort.Direction.ASC,"kcal"));
            }
        }

        Page<Diet> tmp = dietRepository.findDietByNameContaining(name, pageRequest);
        Page<DietSearchDTO> map = tmp.map(t -> new DietSearchDTO(t.getId(), t.getName()));
        return map;
    }

    //식단의 상세 정보
    @GetMapping("/diet/{id}")
    public ResponseEntity<ResponseUserDTO> dietInfo(@PathVariable("id") Long id){
        System.out.println("실행");
        Diet diet = dietRepository.findById(id).get();
        DietInfoDTO dietInfoDTO = new DietInfoDTO(diet);
        ResponseUserDTO result = new ResponseUserDTO<>();
        result.setData(dietInfoDTO);

        return ResponseEntity.ok().body(result);

    }
}
