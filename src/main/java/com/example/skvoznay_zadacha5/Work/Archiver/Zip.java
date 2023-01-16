package com.example.skvoznay_zadacha5.Work.Archiver;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

public class Zip implements Archiver {
    @Override
    public String unarchiveFile(String nameFile) {
        String name="";
        try(ZipInputStream zin = new ZipInputStream(new FileInputStream(nameFile)))
        {
            ZipEntry entry;

            long size;
            while((entry=zin.getNextEntry())!=null){

                name = entry.getName(); // получим название файла
                size=entry.getSize();  // получим его размер в байтах
                System.out.printf("File name: %s \t File size: %d \n", name, size);

                // распаковка
                FileOutputStream fout = new FileOutputStream(name);
                for (int c = zin.read(); c != -1; c = zin.read()) {
                    fout.write(c);
                }

                fout.flush();
                zin.closeEntry();
                fout.close();
             /*   FileReader fr = new FileReader(name);
                Scanner scanner = new Scanner(fr);
                System.out.println(scanner.nextLine());
              */

            }
        }
        catch(Exception ex){

            System.out.println(ex.getMessage());

        }
        return name;
    }

    @Override
    public String archiveFile(String nameFile) {

        try(ZipOutputStream zout = new ZipOutputStream(new FileOutputStream(nameFile+".zip"));
            FileInputStream fis= new FileInputStream(nameFile))
        {
            ZipEntry entry1=new ZipEntry(nameFile);
            zout.putNextEntry(entry1);
            // считываем содержимое файла в массив byte
            byte[] buffer = new byte[fis.available()];
            fis.read(buffer);
            // добавляем содержимое к архиву
            zout.write(buffer);
            // закрываем текущую запись для новой записи
            zout.closeEntry();
        }
        catch(Exception ex){

            System.out.println(ex.getMessage());
        }
        return nameFile+".zip";
    }
}
