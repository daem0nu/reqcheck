package com.example.repcheck;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.nio.file.Paths;
import java.util.Scanner;

public class FileUtils {
    public String InFilename1;
    public String InFilename2;
    public String OutFilename;

    public String read (String InFilename) throws IOException {
        Scanner scanner = new Scanner(Paths.get(InFilename), StandardCharsets.UTF_8.name());
        String content = scanner.useDelimiter("\\A").next();
        scanner.close();
        return content;
    }

    public void write (String OutFilename,String content) throws IOException {
        FileWriter fw = new FileWriter(OutFilename,true);
        PrintWriter pw=new PrintWriter(fw);
        pw.println(content);   //字符串末尾不需要换行符
        pw.close () ;
        fw.close () ;
    }
}
