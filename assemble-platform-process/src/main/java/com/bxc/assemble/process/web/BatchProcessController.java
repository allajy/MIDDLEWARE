package com.bxc.assemble.process.web;

import com.bxc.assemble.common.model.http.ResultResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RequestMapping("/api/batch")
@RestController
public class BatchProcessController {

    /**
     * 创建key
     * @param queueId
     * @return
     */
    @GetMapping("/process]")
    public ResultResponse keyGenerator(@RequestParam("queueId") String queueId){
        try {
            return ResultResponse.success();
        }catch (Exception e){
            log.error("keyGenerator is failure!",e);
            return ResultResponse.failure("keyGenerator is failure!");
        }
    }
}
