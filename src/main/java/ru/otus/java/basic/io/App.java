package ru.otus.java.basic.io;

import static ru.otus.java.basic.io.TextFile.modifyFile;
import static ru.otus.java.basic.io.TextFile.printFileContent;

import java.io.File;
import java.util.Map;
import java.util.Scanner;

public class App {

  public static void main(String[] args) {
    Scanner console = new Scanner(System.in);
    String input;
    String content;
    String directory = "./files";
    String extension = ".txt";
    Map<String, File> textFiles = TextFile.findTextFiles(directory, extension);
    TextFile.printFiles(textFiles);
    System.out.println("Укажите имя файла для работы:");
    input = console.nextLine();
    if (textFiles.get(input + extension) == null) {
      System.out.println("Файла с таким именем не существует.");
    } else {
      printFileContent(textFiles.get(input + extension));
      System.out.println("Введите любую строку для записи в этот файл:");
      content = console.nextLine();
      modifyFile(textFiles.get(input + extension), content);
    }
  }
}
