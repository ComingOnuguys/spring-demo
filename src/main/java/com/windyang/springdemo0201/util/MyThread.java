package com.windyang.springdemo0201.util;


import cn.hutool.core.thread.ThreadUtil;

/**
 * @author windyang
 */
public class MyThread implements Runnable{
        @Override
        public void run() {
            while(true){
                //获取cpu利用率
                ToolUtils.getOsInfo();
                //获取内存数据
                ToolUtils.getMemoryInfo();
                //获取硬盘io
                ToolUtils.getDiskIORate();
                ThreadUtil.safeSleep(100);
            }

        }
}