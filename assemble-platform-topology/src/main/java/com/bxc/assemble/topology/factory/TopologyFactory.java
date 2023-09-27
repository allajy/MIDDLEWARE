package com.bxc.assemble.topology.factory;

import com.google.common.graph.*;

import java.util.Comparator;

public class TopologyFactory {

    /**
     * 创建拓扑
     * @param isCycle
     * @param nodeNumber
     * @param comparable
     * @param <NODE>
     * @param <VALUE>
     * @return
     */
    public static <NODE,VALUE> MutableValueGraph createMutableValueGraph(boolean isCycle, int nodeNumber, Comparator comparable){
        return ValueGraphBuilder.directed().allowsSelfLoops(isCycle)
                .nodeOrder(ElementOrder.sorted(comparable)).build();
    }

    /**
     * 创建拓扑
     * @param nodeNumber
     * @param comparable
     * @param <NODE>
     * @param <VALUE>
     * @return
     */
    public static <NODE,VALUE> MutableValueGraph createMutableValueGraph( int nodeNumber, Comparator comparable){
        return createMutableValueGraph(Boolean.TRUE,nodeNumber,comparable);
    }

    /**
     * 创建拓扑
     * @param comparable 排序比较器
     * @param <NODE> 节点
     * @param <VALUE> 数值
     * @return
     */
    public static <NODE,VALUE> MutableValueGraph createMutableValueGraph(Comparator comparable){
        return createMutableValueGraph(10000,comparable);
    }

    /**
     * 创建拓扑
     * @param <NODE>
     * @param <VALUE>
     * @return
     */
    public static <NODE,VALUE> MutableValueGraph createMutableValueGraph(){
        return createMutableValueGraph(Comparator.naturalOrder());
    }

    /**
     * 创建拓扑
     * @param isCycle
     * @param nodeNumber
     * @param comparable
     * @param <NODE>
     * @param <VALUE>
     * @return
     */
    public static <NODE,VALUE> MutableGraph createMutableGraph(boolean isCycle, int nodeNumber, Comparator comparable){
        return GraphBuilder.directed().allowsSelfLoops(isCycle)
                .nodeOrder(ElementOrder.sorted(comparable)).build();
    }

    /**
     * 创建拓扑
     * @param nodeNumber
     * @param comparable
     * @param <NODE>
     * @param <VALUE>
     * @return
     */
    public static <NODE,VALUE> MutableGraph createMutableGraph(int nodeNumber, Comparator comparable){
        return createMutableGraph(Boolean.TRUE,nodeNumber,comparable);
    }

    /**
     * 创建拓扑
     * @param comparable 排序比较器
     * @param <NODE> 节点
     * @param <VALUE> 数值
     * @return
     */

    public static <NODE,VALUE> MutableGraph createMutableGraph(Comparator comparable){
        return createMutableGraph(10000,comparable);
    }

    /**
     * 创建拓扑
     * @param <NODE>
     * @param <VALUE>
     * @return
     */
    public static <NODE,VALUE> MutableGraph createMutableGraph(){
        return createMutableGraph(Comparator.naturalOrder());
    }


    /**
     * 创建拓扑
     * @param isCycle
     * @param nodeNumber
     * @param comparable
     * @param <NODE>
     * @param <VALUE>
     * @return
     */
    public static <NODE,VALUE> MutableNetwork createMutableNetWork(boolean isCycle, int nodeNumber,int lineNumber, Comparator comparable){
        return NetworkBuilder.directed()
                .allowsParallelEdges(true)
                .nodeOrder(ElementOrder.sorted(comparable))
                .expectedNodeCount(nodeNumber)
                .expectedEdgeCount(lineNumber)
                .build();
    }

    /**
     * 创建拓扑
     * @param comparable
     * @param <NODE>
     * @param <VALUE>
     * @return
     */
    public static <NODE,VALUE> MutableNetwork createMutableNetWork(Comparator comparable){
        return createMutableNetWork(Boolean.TRUE,10000,10000,comparable);
    }


    /**
     * 创建拓扑
     * @param <NODE> 节点
     * @param <VALUE> 数值
     * @return
     */
    public static <NODE,VALUE> MutableNetwork createMutableNetWork(){
        return createMutableNetWork(Comparator.naturalOrder());
    }

}
