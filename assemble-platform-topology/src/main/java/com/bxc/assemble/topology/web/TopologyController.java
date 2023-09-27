package com.bxc.assemble.topology.web;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.bxc.assemble.topology.factory.TopologyGraphAdapter;
import com.bxc.assemble.topology.factory.TopologyGraphSelector;
import com.bxc.assemble.topology.factory.impl.JSONTopologyGraphAdapter;
import com.google.common.graph.MutableNetwork;
import com.bxc.assemble.common.model.http.ResultResponse;
import com.bxc.assemble.topology.factory.TopologyGraphPainter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@RequestMapping("/api/topo")
@RestController
public class TopologyController {


    @Autowired
    RedisTemplate redisTemplate;



    @GetMapping("/painting")
    public ResultResponse painting(@RequestParam("painting") String painting){
        try {
            TopologyGraphPainter<String,String> topologyGraphPainter = new TopologyGraphPainter();

            Map<String,Object> objectMap = new HashMap<>();

            JSONObject jsonObject = new JSONObject();
            JSONArray jsonArray = new JSONArray();
            jsonArray.add("second node");
            jsonArray.add("third node");
            jsonObject.put(TopologyGraphAdapter.NEXT_NODE_IDS,jsonArray);
            objectMap.put("start Node",jsonObject);

            JSONObject jsonObject2 = new JSONObject();
            JSONArray jsonArray2 = new JSONArray();
            jsonArray2.add("fouth node");
            jsonArray2.add("fith node");
            jsonObject2.put(TopologyGraphAdapter.NEXT_NODE_IDS,jsonArray2);
            objectMap.put("second node",jsonObject2);

            JSONTopologyGraphAdapter jsonTopologyGraphAdapter = new JSONTopologyGraphAdapter();

            MutableNetwork mutableNetwork = jsonTopologyGraphAdapter.transfer(objectMap);

            redisTemplate.opsForValue().set("test",mutableNetwork);
            MutableNetwork mutableNetwork2 = (MutableNetwork) redisTemplate.opsForValue().get("test");
            TopologyGraphSelector topologyGraphSelector = new TopologyGraphSelector(mutableNetwork2,"test");
            System.out.println(topologyGraphSelector.getNextNodes("start Node"));
            System.out.println(topologyGraphSelector.getNextNodes("second node"));
            System.out.println(topologyGraphSelector.getPreNodes("start Node"));
            System.out.println(topologyGraphSelector.getPreNodes("second node"));
            return ResultResponse.success();
        }catch (Exception e){
            log.error("keyGenerator is failure!",e);
            return ResultResponse.failure("keyGenerator is failure!");
        }
    }
}
