package com.example.demo.service;

import com.example.demo.dto.BMIRequest;
import com.example.demo.model.BMIResult;
import org.springframework.stereotype.Component;

@Component
public class BMIServiceImpl implements BMIService {
    @Override
    public BMIResult calculateBMI(BMIRequest bmiParams) {
        float bmiIndex = bmiParams.getWeight() / (bmiParams.getHeight() * bmiParams.getHeight());
        String category;
        String recommendation;
        if (bmiIndex < 15) {
            category = "Ốm đói";
            recommendation = "Đề nghị ăn bồi dưỡng thêm";
        } else if (bmiIndex < 16) {
            category = "Rất gầy";
            recommendation = "Đề nghị ăn bồi dưỡng thêm";
        } else if (bmiIndex < 18.5) {
            category = "Thiếu cân";
            recommendation = "Đề nghị ăn bồi dưỡng thêm";
        } else if (bmiIndex < 25) {
            category = "Chuẩn mực";
            recommendation = "Đề nghị luôn giữ gìn sức khỏe";
        } else if (bmiIndex < 30) {
            category = "Hơi béo";
            recommendation = "Đề nghị giảm cân nhẹ";
        } else if (bmiIndex < 35) {
            category = "Rất béo";
            recommendation = "Đề nghị giảm cân";
        } else if (bmiIndex < 40) {
            category = "Khủng long";
            recommendation = "Đề nghị giảm cân";
        } else {
            category = "Gọi cần cẩu";
            recommendation = "Đề nghị giảm cân";
        }

        return BMIResult.builder()
                .withBmiIndex(bmiIndex)
                .withCategory(category)
                .withRecommendation(recommendation)
                .build();

    }
}
