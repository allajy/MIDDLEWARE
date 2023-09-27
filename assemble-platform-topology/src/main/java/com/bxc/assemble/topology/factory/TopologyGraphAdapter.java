package com.bxc.assemble.topology.factory;


@FunctionalInterface
public interface TopologyGraphAdapter<IN,OUT>{

    String PRV_NODE_IDS = "prevNodeIds";

    String NEXT_NODE_IDS = "nextNodeIds";

    OUT transfer(IN in);

}
