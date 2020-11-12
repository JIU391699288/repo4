package com.zl.feign;

import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient("problem-system")
public interface QuestionFeign {

    @RequestMapping("/question/select")
    public String selectQuestion(@RequestParam(value = "question") String question);
}
