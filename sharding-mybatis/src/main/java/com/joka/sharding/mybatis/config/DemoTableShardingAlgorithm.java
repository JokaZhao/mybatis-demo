package com.joka.sharding.mybatis.config;

import io.shardingjdbc.core.api.algorithm.sharding.PreciseShardingValue;
import io.shardingjdbc.core.api.algorithm.sharding.standard.PreciseShardingAlgorithm;

import java.util.Collection;

/**
 * Created on 2019/10/9 15:39.
 *
 * @author zhaozengjie
 * Description : 分表策略
 */
public class DemoTableShardingAlgorithm implements PreciseShardingAlgorithm<String>{

    @Override
    public String doSharding(Collection<String> collection, PreciseShardingValue<String> preciseShardingValue) {

        int i = preciseShardingValue.hashCode();
        String name = null;
        String lastName = null;
        for (String each : collection) {
            if (each.endsWith(i % 4+"")) {
                name =  each;
            }
            lastName = each;
        }
        if (name == null){

            name = lastName;

        }
        return name;
    }
}
