package com.example.skvoznay_zadacha5.Work.Encryptor;

import java.io.File;

public class Encryptor {
    private File file;

    private FileEncryption fileEncryptionObj;


    public File encoding(File inputFile, boolean isDecrypt) {
        if (isDecrypt) {
            try {
                fileEncryptionObj = new FileEncryption(inputFile.getAbsolutePath(), "123", FileEncryption.DECRYPT_MODE);
                fileEncryptionObj.start();
                file = fileEncryptionObj.getFile();
                return file;

            } catch (FileEncryptionException e) {
                System.out.println("FileEncryption!");
            }
        } else {
            try {
                fileEncryptionObj = new FileEncryption(inputFile.getAbsolutePath(), "123", FileEncryption.ENCRYPT_MODE);
                fileEncryptionObj.start();
                file = fileEncryptionObj.getFile();
                return file;

            } catch (FileEncryptionException e) {
                System.out.println("FileEncryption!");
            }
        }

        return null;
    }
}
