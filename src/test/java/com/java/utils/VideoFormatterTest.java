package com.java.utils;

import org.junit.Assert;
import org.junit.Test;

import java.io.File;
import java.io.IOException;

public class VideoFormatterTest {


    @Test
    public void createTempVideoFileTest() {
        String dir = "/Documents/notes/test/dir";
        File tempVideoFile = null;
        try {
            tempVideoFile = VideoFormatter.createTempVideoFile(dir);

            Assert.assertTrue(tempVideoFile.exists());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(tempVideoFile != null) {
                tempVideoFile.deleteOnExit();
            }
        }
    }

}
