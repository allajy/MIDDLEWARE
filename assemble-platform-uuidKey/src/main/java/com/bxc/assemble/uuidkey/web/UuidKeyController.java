package com.bxc.assemble.uuidkey.web;

import com.bxc.assemble.common.model.http.ResultResponse;
import com.bxc.assemble.uuidkey.base.UUIDGenerator;
import com.bxc.assemble.uuidkey.hutool.HutoolUUIDGenerator;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;
import java.util.Optional;

@Slf4j
@RestController
@Api(value="唯一id生成器",tags = {"唯一ID生成器组件"},description = "包含百度、糊涂、雪花三种")
@RequestMapping("/api/uuid")
public class UuidKeyController {


    @Autowired
    Map<String, UUIDGenerator> uuidGeneratorMap;


    private static final UUIDGenerator UUID_GENERATOR = new HutoolUUIDGenerator();

    /**
     * 创建key
     * @param uuidType
     * @return
     */
    @GetMapping("/key")
    @ApiOperation(value="唯一id生成器",notes = "包含百度、糊涂、雪花三种")
    public ResultResponse keyGenerator(@RequestParam("uuidType") String uuidType){
        try {
            UUIDGenerator uuidGenerator = uuidGeneratorMap.getOrDefault(uuidType,UUID_GENERATOR);
            return ResultResponse.success(Optional.ofNullable(uuidGenerator).orElse(UUID_GENERATOR).nextId());
        }catch (Exception e){
            log.error("keyGenerator is failure!",e);
            return ResultResponse.failure("keyGenerator is failure!");
        }
    }


}
