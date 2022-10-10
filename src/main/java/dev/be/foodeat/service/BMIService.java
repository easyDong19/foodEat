package dev.be.foodeat.service;


import dev.be.foodeat.dto.BmiDTO;
import org.springframework.stereotype.Service;

@Service
public class BMIService {

    public BmiDTO getUserBMI(double height, double weight){
        //BMI지표
        BmiDTO bmIDTO = new BmiDTO();
        double mheight = height/100; // cm -> m 변환
        double index = weight/(mheight*mheight);
        bmIDTO.setIndex(index);
        //BMI 이상적 몸무게(하한, 상한)
        double ideal_weight[] = {18.5*mheight*mheight,22.9*mheight*mheight};
        bmIDTO.setIdeal_weight(ideal_weight);
        //BMI 칼로리(하한, 상한)

        double kcal = judgeKcal(index) * weight;
        bmIDTO.setKcal(kcal);

        return bmIDTO;
    }

    public static double judgeKcal(double index){
        double result = 30;
        if(index < 18.5){
            //저체중 35
            result = 35;
        }
        else if(index>=25){
            //과체중 20
            result = 20;
        }
        return result;
    }

}
