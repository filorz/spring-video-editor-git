package com.java.utils;

import com.java.exceptionn.FFMpegExceptionn;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class VideoFormatter {

    public static String fileNameFormat(List<String> fileNameList) {
        StringBuilder strBuilder = new StringBuilder();
        for (int i = 0; i < fileNameList.size(); i++) {
            if(i != fileNameList.size() - 1) {
                strBuilder.append(fileNameList.get(i)).append("|");
            } else {
                strBuilder.append(fileNameList.get(i));
            }
        }
        return strBuilder.toString();
    }

    public static File createTempVideoFile(String dir) throws IOException {
        File temp = File.createTempFile("video_temp_",".txt");
        if(temp.exists()) {
            writeVideoList(dir, temp);
        }
        return temp;
    }

    public static void writeVideoList(String sourcePath, File file) {
        File[] files = BaseFileUtil.listFiles(sourcePath);
        try(FileWriter fw = new FileWriter(file, true);
            BufferedWriter bw = new BufferedWriter(fw)) {


            for (File item : files) {
                if(!item.isHidden()) {
                    bw.write("file " + item.getAbsolutePath());
                    bw.newLine();
                }
            }
            bw.flush();
        } catch (IOException e) {
            throw new FFMpegExceptionn(e);
        }
    }

}
