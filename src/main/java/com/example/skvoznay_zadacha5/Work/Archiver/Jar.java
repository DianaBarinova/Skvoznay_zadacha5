package com.example.skvoznay_zadacha5.Work.Archiver;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.jar.JarEntry;
import java.util.jar.JarInputStream;
import java.util.jar.JarOutputStream;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Jar implements Archiver{
    @Override
    public String archiveFile(String nameFile) {
      File file=new File(nameFile);
            Pattern pattern = Pattern.compile("^(.+)\\.(.+)$");
            Matcher matcher = pattern.matcher(file.getName());
            boolean matchFound = matcher.find();
            File result = new File(matcher.group(1) + ".jar");
            try(JarOutputStream jout = new JarOutputStream(new FileOutputStream(result));
                FileInputStream fis= new FileInputStream(file))
            {
                JarEntry entry1=new JarEntry(file.getName());
                jout.putNextEntry(entry1);
                byte[] buffer = new byte[fis.available()];
                fis.read(buffer);
                jout.write(buffer);
                jout.closeEntry();
            }
            catch(Exception ex){

                System.out.println(ex.getMessage());
            }
            return result.getName();
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

