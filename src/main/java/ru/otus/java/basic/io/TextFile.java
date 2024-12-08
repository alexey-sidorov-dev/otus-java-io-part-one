package ru.otus.java.basic.io;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Set;

public class TextFile {

  static Map<String, File> findTextFiles(String directory, String extension) {

    File folder = new File(directory);
    FilenameFilter filenameFilter = (dir, name) -> name.toLowerCase(Locale.ROOT)
        .endsWith(extension);
    File[] filesList = folder.listFiles(filenameFilter);
    Map<String, File> filesMap = new HashMap<>();
    if (filesList == null) {
      return filesMap;
    }

    for (File file : filesList
    ) {
      filesMap.put(file.getName(), file);
    }

    return filesMap;
  }

  static void printFiles(Map<String, File> filesMap) {
    System.out.println("Список файлов:");
    Set<String> names = filesMap.keySet();
    if (names.isEmpty()) {
      return;
    }

    for (Object name : names.toArray()
    ) {
      System.out.println(name);
    }
  }

  static void printFileContent(File file) {
    System.out.println("Содержимое выбранного файла:");
    try (InputStreamReader in = new InputStreamReader(
        new BufferedInputStream(new FileInputStream(file)))) {
      int n = in.read();
      while (n != -1) {
        System.out.print((char) n);
        n = in.read();
      }
      System.out.println();
    } catch (IOException e) {
      System.out.println("Во время чтения содержимого файла произошла ошибка: " + e.getMessage());
    }
  }

  static void modifyFile(File file, String content) {
    try (BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream(file, true))) {
      byte[] buffer = content.getBytes(StandardCharsets.UTF_8);
      for (byte b : buffer) {
        out.write(b);
      }
    } catch (IOException e) {
      System.out.println("Во время записи в файл произошла ошибка: " + e.getMessage());
    }
  }
}
