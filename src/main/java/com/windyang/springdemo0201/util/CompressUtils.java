package com.windyang.springdemo0201.util;

import cn.hutool.system.oshi.CpuInfo;
import cn.hutool.system.oshi.OshiUtil;
import com.alibaba.fastjson2.JSON;
import com.google.common.util.concurrent.ThreadFactoryBuilder;
import org.apache.commons.compress.archivers.zip.ParallelScatterZipCreator;
import org.apache.commons.compress.archivers.zip.UnixStat;
import org.apache.commons.compress.archivers.zip.ZipArchiveEntry;
import org.apache.commons.compress.archivers.zip.ZipArchiveOutputStream;
import org.apache.commons.compress.parallel.InputStreamSupplier;
import org.apache.commons.io.input.NullInputStream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.*;

/**
 * @author windyang
 */
public class CompressUtils {

    public static final Logger logger = LoggerFactory.getLogger(CompressUtils.class);

    public static void main(String[] args) throws IOException, ExecutionException, InterruptedException {
        Thread t = new Thread(new MyThread());
        t.start(); // 启动新线程


        testFile();
    }

    public static void testFile() throws IOException, ExecutionException, InterruptedException {


        File file = new File("D:\\test\\Thunder");
        String zipOutName = "D:\\test\\testCompressSpeed.zip";
        ThreadFactory factory = new ThreadFactoryBuilder().setNameFormat("compressFileList-pool-").build();
        ExecutorService executor = new ThreadPoolExecutor(5, 10, 60, TimeUnit.SECONDS, new ArrayBlockingQueue<>(1024), factory, new ThreadPoolExecutor.CallerRunsPolicy());
        ParallelScatterZipCreator parallelScatterZipCreator = new ParallelScatterZipCreator(executor);
        OutputStream outputStream = new FileOutputStream(zipOutName);
        ZipArchiveOutputStream zipArchiveOutputStream = new ZipArchiveOutputStream(outputStream);
        zipArchiveOutputStream.setEncoding("UTF-8");
        compressFileList(zipOutName, file, parallelScatterZipCreator);

        parallelScatterZipCreator.writeTo(zipArchiveOutputStream);
        zipArchiveOutputStream.close();
        outputStream.close();

        logger.info("ParallelCompressUtil->ParallelCompressUtil-> info:{}", JSON.toJSONString(parallelScatterZipCreator.getStatisticsMessage()));


        /*File file1 = new File("D:\\test\\Thunder");
        long l = System.currentTimeMillis();
        File file = new File("D:\\test\\testCompressSpeedHutool.zip");

        ZipUtil.zip(file, true, Objects.requireNonNull(file1.listFiles()));
        long end = System.currentTimeMillis();
        logger.info("time = " + (end - l));*/
    }

    /**
     * 批量压缩文件 v4.0
     *
     * @param dir  需要压缩的文件名称列表(包含相对路径)
     * @param zipOutName 压缩后的文件名称
     **/
    public static void compressFileList(String zipOutName, File dir, ParallelScatterZipCreator parallelScatterZipCreator) throws IOException, ExecutionException, InterruptedException {

        if (dir == null) {
            return;
        }
        if(dir.isFile()){
            addEntry(dir, parallelScatterZipCreator);
            return;
        }

        if (Objects.requireNonNull(dir.listFiles()).length == 0) {
            addEntry(dir, parallelScatterZipCreator);
            return;
        }
        for (File file : Objects.requireNonNull(dir.listFiles())) {
            if (file.isDirectory()) {
                compressFileList(zipOutName,file, parallelScatterZipCreator);
            } else {
                addEntry(file, parallelScatterZipCreator);
            }
        }

    }


    private static void addEntry(File file, ParallelScatterZipCreator parallelScatterZipCreator) throws IOException {
        ZipArchiveEntry archiveEntry = new ZipArchiveEntry(file.getName());
        archiveEntry.setMethod(ZipArchiveEntry.DEFLATED);
        final InputStreamSupplier inputStreamSupplier = () -> {
            try {
                if(file.isDirectory()){
                    return new NullInputStream(0);
                }
                return new FileInputStream(file);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
                return new NullInputStream(0);
            }
        };
        ZipArchiveEntry zipArchiveEntry = new ZipArchiveEntry(file.getName());
        zipArchiveEntry.setMethod(ZipArchiveEntry.DEFLATED);
        zipArchiveEntry.setSize(file.length());
        zipArchiveEntry.setUnixMode(UnixStat.FILE_FLAG | 436);
        parallelScatterZipCreator.addArchiveEntry(zipArchiveEntry, inputStreamSupplier);
    }







}
