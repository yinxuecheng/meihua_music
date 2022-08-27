package com.meihua.utils;

import com.meihua.enums.FileType;

/**
 * 根据后缀名判断文件的类型工具类
 */
public class FileTypeTransformer {

    public static FileType getFileTypeFromExt(String ext) {

        if (isAudio(ext)) {
            return FileType.AUDIO;
        }

        if (isImage(ext)) {
            return FileType.IMAGE;
        }

        if (isVideo(ext)) {
            return FileType.VIDEO;
        }

        return FileType.OTHER;
    }

    private static boolean isVideo(String ext) {
        String[] videoExt = {"vob","mp4","avi","flv",
                "f4v","wmv","mov","rmvb","mkv","mpg",
                "m4v","webm","rm","mpeg","asf","ts","mts"};
        for (String perExt: videoExt) {
            if (perExt.equals(ext)){
                return Boolean.TRUE;
            }
        }
        return Boolean.FALSE;
    }

    private static boolean isImage(String ext) {
        String[] imageExt = {"png","jpg","jpeg"};
        for (String perExt: imageExt) {
            if (perExt.equals(ext)){
                return Boolean.TRUE;
            }
        }
        return Boolean.FALSE;
    }

    private static boolean isAudio(String ext) {
        String[] audioExt = {"mp3","wav"};
        for (String perExt: audioExt) {
            if (perExt.equals(ext)){
                return Boolean.TRUE;
            }
        }
        return Boolean.FALSE;
    }
}
