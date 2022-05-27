package com.windyang.springdemo0201.test;

import cn.hutool.core.collection.ListUtil;
import com.google.common.collect.Lists;
import org.apache.commons.lang3.StringUtils;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author windyang
 */
public class JdkTest {

    public void test(){
        List<Map<String,Object>> list = new ArrayList<>();
        Map<String,Object> map = new HashMap<>();
        map.put("aa", "aa");
        map.put("cc", null);

        Map<String,Object> map2 = new HashMap<>();
        map2.put("aa", "aa1");
        map2.put("cc", null);

        list.stream().map(x -> StringUtils.defaultString("aa")).filter(StringUtils::isNotBlank).collect(Collectors.toList());
    }
}
