package com.example.skvoznay_zadacha5.Work;

public class FileUtilities {
    public String getFileExtension(String nameFile) {
        String util;
        if (nameFile.lastIndexOf(".") != -1 && nameFile.lastIndexOf(".") != 0) {
            util = nameFile.substring(nameFile.lastIndexOf(".") + 1);
            return util;
        }
        return "";
    }
}
