package com.windyang.springdemo0201.util;

import cn.hutool.system.oshi.CpuInfo;
import cn.hutool.system.oshi.OshiUtil;

import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;

/**
 * @author windyang
 */
public class ToolUtils {

    /**
     * 获取cpu利用率
     */
    public static void getOsInfo(){
        CpuInfo cpuInfo = OshiUtil.getCpuInfo();
        double free = cpuInfo.getFree();
        DecimalFormat format = new DecimalFormat("#.00");
        System.out.println("cpu利用率：" + Double.parseDouble(format.format(100.0D - free)));
    }

    /**
     * 获取内存数据
     */
    public static void getMemoryInfo(){
        System.out.println("内存总量：" + OshiUtil.getMemory().getTotal()/1024/1024);
        System.out.println("已用内存：" + OshiUtil.getMemory().getAvailable()/1024/1024);
    }

    public static void getDiskIORate() {
        String CMD = "iostat -d -x 1 2";
        String info = Runcommand.runCommand(CMD);
        String diskName = null;
        double rkb = 0.0;
        double wkb = 0.0;
        Map<String,Object> json = new HashMap<>();
        String[] data = info.split("\n");
        for (int i = 7; i < data.length; i++) {
            String[] numdata = data[i].split(" +");
            diskName = numdata[0];//磁盘名称
            rkb = Double.parseDouble(numdata[5]);//磁盘读数据速率
            wkb = Double.parseDouble(numdata[6]);//磁盘写数据速率
            json.put("diskName", diskName);
            json.put("rkb", rkb);
            json.put("wkb", wkb);

            System.out.println("硬盘名称 = " + diskName);
            System.out.println("磁盘读数据速率 = " + rkb);
            System.out.println("磁盘写数据速率 = " + wkb);
        }

    }

}
