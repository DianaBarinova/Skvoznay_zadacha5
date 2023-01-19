package com.example.skvoznay_zadacha5.Work.Archiver;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.jar.JarEntry;
import java.util.jar.JarInputStream;
import java.util.jar.JarOutputStream;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class Jar implements Archiver {
    @Override
    public String archiveFile(String nameFile) {
        try (ZipOutputStream zout = new ZipOutputStream(new FileOutputStream(nameFile + ".jar"));
             FileInputStream fis = new FileInputStream(nameFile)) {
            ZipEntry entry1 = new ZipEntry(nameFile);
            zout.putNextEntry(entry1);
            // считываем содержимое файла в массив byte
            byte[] buffer = new byte[fis.available()];
            fis.read(buffer);
            // добавляем содержимое к архиву
            zout.write(buffer);
            // закрываем текущую запись для новой записи
            zout.closeEntry();
        } catch (Exception ex) {

            System.out.println(ex.getMessage());
        }
        return nameFile + ".jar";
    }




    @Override
    public String unarchiveFile(String nameFile) {
            File file=new File(nameFile);
                File result = null;
                try(JarInputStream jin = new JarInputStream(new FileInputStream(file)))
                {
                    JarEntry entry;
                    String name;
                    long size;

                    while((entry=jin.getNextJarEntry())!=null){

                        name = entry.getName();
                        size=entry.getSize();

                        result = new File(name);
                        FileOutputStream fout = new FileOutputStream(result);
                        for (int c = jin.read(); c != -1; c = jin.read()) {
                            fout.write(c);
                        }
                        fout.flush();
                        jin.closeEntry();
                        fout.close();
                    }
                }
                catch(Exception ex){

                    System.out.println(ex.getMessage());
                }
                String s=new String(result.getName());

                return s;
            }
        }

