package com.joka.sharding.mybatis.config;

import com.alibaba.fastjson.JSON;
import io.shardingjdbc.core.api.algorithm.sharding.PreciseShardingValue;
import io.shardingjdbc.core.api.algorithm.sharding.standard.PreciseShardingAlgorithm;
import lombok.extern.slf4j.Slf4j;

import java.util.Collection;

/**
 * Created on 2019/10/8 20:02.
 *
 * @author zhaozengjie
 * Description : 分库策略
 */
@Slf4j
public class DemoDatabaseShardingAlgorithm implements PreciseShardingAlgorithm<String> {
    @Override
    public String doSharding(Collection<String> collection, PreciseShardingValue<String> preciseShardingValue) {
        log.info("collection:" + JSON.toJSONString(collection) + ",preciseShardingValue:" + JSON.toJSONString(preciseShardingValue));

        for (String each : collection) {
            if (each.endsWith(preciseShardingValue.hashCode() % 2+"")) {
                return each;
            }
        }
        throw new IllegalArgumentException();
    }
}
