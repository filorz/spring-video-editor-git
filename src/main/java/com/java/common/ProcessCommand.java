package com.java.common;


import com.java.dto.Result;
import com.java.exceptionn.FFMpegExceptionn;

import java.io.IOException;
import java.util.List;

public class ProcessCommand {

    public static Result start(List<String> command) {
        ProcessBuilder builder = new ProcessBuilder(command);
        Process process = null;
        try {
            process = builder.start();
            return StreamHandlerCommon.closeStreamQuietly(process);
        } catch (IOException e) {
            throw new FFMpegExceptionn(e);
        }
    }

}
