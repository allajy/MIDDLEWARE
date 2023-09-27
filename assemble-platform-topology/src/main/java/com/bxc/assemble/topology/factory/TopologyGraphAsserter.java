package com.bxc.assemble.topology.factory;

import com.google.common.graph.MutableNetwork;
import lombok.Getter;

/**
 * @project-name:assemble-platform
 * @package-name:com.hyts.assemble.topology.factory
 * @description: 拓扑断言操作
 */
public class TopologyGraphAsserter<NODE,LINE> {

    /**
     * 拓扑模型对象
     */
    @Getter
    private MutableNetwork<NODE,LINE> networkTopology;

    /**
     * 拓扑断言操作
     * @param networkTopology
     */
    public TopologyGraphAsserter(MutableNetwork<NODE, LINE> networkTopology) {
        this.networkTopology = networkTopology;
    }

    /**
     * 是否链接
     * @param PRE
     * @param NEXT
     * @return
     */
    public boolean isConnected(NODE PRE,NODE NEXT){
        return networkTopology.hasEdgeConnecting(PRE,NEXT);
    }

    /**
     * 是否包含输出的Node
     * @return
     */
    public boolean containOutNode(NODE node,NODE targetNode){
        return networkTopology.successors(node).stream().anyMatch(param->param.equals(targetNode));
    }

    /**
     * 是否包含输出的线
     * @param node
     * @param targetLine
     * @return
     */
    public boolean containOutLine(NODE node,LINE targetLine){
        return networkTopology.outEdges(node).stream().anyMatch(param->param.equals(targetLine));
    }

    /**
     *
     * @param node
     * @param targetLine
     * @return
     */
    public boolean containInLine(NODE node,LINE targetLine){
        return networkTopology.inEdges(node).stream().anyMatch(param->param.equals(targetLine));
    }

    /**
     *
     * @param node
     * @param targetLine
     * @return
     */
    public boolean containCrossLine(NODE node,LINE targetLine){
        return networkTopology.incidentEdges(node).stream().anyMatch(param->param.equals(targetLine));
    }

    /**
     * 是否允许并行线路
     * @return
     */
    public boolean allowParallelLine(){
       return networkTopology.allowsParallelEdges();
    }

    /**
     * 是否允许环路操作
     * @return
     */
    public boolean allowCycle(){
        return networkTopology.allowsSelfLoops();
    }

}
