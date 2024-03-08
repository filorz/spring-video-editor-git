package com.java.utils;

import com.java.dto.Result;
import org.junit.Assert;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class VideoTest {

    private static final String ffmpegEXE = "C:/Users/Filipp/Documents/ffmpeg/bin/ffmpeg.exe";

    public static final Integer EXPECTED = 0;

    @Test
    public void testConverTest() throws IOException {
        String inputPath = "/Users/Filipp/Documents/test/2222.mp4";
        String outPutPath = "/Users/Filipp/Documents/test/1/convert.flv";
        VideoOperation ffmpeg = VideoOperation.builder(ffmpegEXE);
        Result result = ffmpeg.videoConvert(inputPath, outPutPath);
        System.out.println(result.getCode());
        System.out.println(result.getErrMessage());
    }

    @Test
    public void testConverTest1() throws IOException {
        String inputPath = "/Users/Filipp/Documents/test/convert.flv";
        String outPutPath = "/Users/Filipp/Documents/test/001f.mpg";
        VideoOperation ffmpeg = VideoOperation.builder(ffmpegEXE);
        Result result = ffmpeg.videoConvert(inputPath, outPutPath);
        System.out.println(result.getCode());
        System.out.println(result.getErrMessage());
    }

//    @Test
//    public void videoScaleTest() {
//        Long inputPath = 2222L;
//        VideoOperation ffmpeg = VideoOperation.builder(ffmpegEXE);
//        Result result = ffmpeg.videoScale(inputPath,640L,360L);
//        System.out.println(result.getCode());
//        System.out.println(result.getErrMessage());
//    }

    @Test
    public void videoRotateTest() throws IOException {
        String inputPath = "/Users/Filipp/Documents/test/2222.mp4";
        String outPutPath = "/Users/Filipp/Documents/test/1/rotate.mp4";
        VideoOperation ffmpeg = VideoOperation.builder(ffmpegEXE);
        Result result = ffmpeg.videoRotate(inputPath,2,"","" , outPutPath);
        System.out.println(result.getCode());
        System.out.println(result.getErrMessage());
    }

    @Test
    public void videoConverToGifTest() throws IOException {
        String inputPath = "/Users/Filipp/Documents/test/11111.mp4";
        String outPutPath = "/Users/Filipp/Documents/test/1/out.gif";
        VideoOperation ffmpeg = VideoOperation.builder(ffmpegEXE);
        Result result = ffmpeg.videoConvertToGif(inputPath,outPutPath, true);
        System.out.println(result.getCode());
        System.out.println(result.getErrMessage());
    }

    @Test
    public void convertorWithBgmTest() throws IOException {
        String inputPath = "/Users/Filipp/Documents/test/11111.mp4";
        String outPutPath = "/Users/Filipp/Documents/test/1/222.mp4";
        String noSoundPath = "/Users/Filipp/Documents/test/1/nosound.mp4";
        String audioPath = "/Users/Filipp/Documents/young.mp3";
        VideoOperation ffmpeg = VideoOperation.builder(ffmpegEXE);
        Result result = ffmpeg.convertorWithBgmNoOriginCommon(inputPath, outPutPath, noSoundPath, audioPath, 5);
        Assert.assertEquals(EXPECTED, result.getCode());
        System.out.println(result.getErrMessage());
    }

    @Test
    public void transformVideoCoverTest() {
        String inputPath = "/Users/Filipp/Documents/test/11111.mp4";
        String imagePath = "/Users/Filipp/Documents/test/mail.jpg";
        String outPutPath = "/Users/Filipp/Documents/test/2/111_bg.mp4";
        VideoOperation ffmpeg = VideoOperation.builder(ffmpegEXE);
        Result result = ffmpeg.transformVideoCover(inputPath, imagePath, outPutPath);
        Assert.assertEquals(EXPECTED, result.getCode());
        System.out.println(result.getErrMessage());
    }

    @Test
    public void mergeMultiOnlineVideosTest() {
        String inputPath = "/Users/Filipp/Documents/test/video.txt";
        String outPutPath = "/Users/Filipp/Documents/test/mutionout.mp4";
        VideoOperation ffmpeg = VideoOperation.builder(ffmpegEXE);
        Result result = ffmpeg.mergeMultiOnlineVideos(new File(inputPath), outPutPath);
        Assert.assertEquals(EXPECTED, result.getCode());
        System.out.println(result.getErrMessage());
        System.out.println(result);
    }

    @Test
    public void mergeMultiVideosOfTsFormatTest() {
        List<String> list = new ArrayList<>();
        list.add("/Users/Filipp/Documents/test/2/1509761497_168.ts");
        list.add("/Users/Filipp/Documents/test/2/1509761556_175.ts");
        list.add("/Users/Filipp/Documents/test/2/1509761539_173.ts");
        String outPutPath = "/Users/Filipp/Documents/test/mergeMultiVideosOfTsFormat.mp4";
        VideoOperation ffmpeg = VideoOperation.builder(ffmpegEXE);
        Result result = ffmpeg.mergeMultiVideosOfTsOrMpegFormat(list, outPutPath);
        Assert.assertEquals(EXPECTED, result.getCode());
        System.out.println(result.getErrMessage());
        System.out.println(result);
    }

    @Test
    public void mergeMultiVideosByFileTest() {
        String inputPath = "/Users/Filipp/Documents/test/video-example.txt";
        String outPutPath = "/Users/Filipp/Documents/test/mergeVideo.mp4";
        VideoOperation ffmpeg = VideoOperation.builder(ffmpegEXE);
        Result result = ffmpeg.mergeMultiVideosByFile(new File(inputPath), outPutPath);
        Assert.assertEquals(EXPECTED, result.getCode());
    }

    @Test
    public void mergeMultiVideosByDirTest() {
        String dir = "/Users/Filipp/Documents/test/dir";
        String outPutPath = "/Users/Filipp/Documents/test/dir/mergeVideo.mp4";
        VideoOperation ffmpeg = VideoOperation.builder(ffmpegEXE);
        Result result = ffmpeg.autoMergeMultiVideosByDir(dir, outPutPath);
        Assert.assertEquals(EXPECTED, result.getCode());
    }


}
