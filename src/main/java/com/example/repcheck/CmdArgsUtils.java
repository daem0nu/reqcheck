package com.example.repcheck;

import java.io.IOException;

public class CmdArgsUtils {
    public static void main(String[] args) throws IOException {
        /*if(args.length!=3||args[0].isEmpty()||args[1].isEmpty()||args[2].isEmpty()){
            System.out.println("useage: java -jar repcheck.jar file1 file2 outfile ");
            System.exit(0);
        }*/

        FileUtils fileUtils = new FileUtils();
        fileUtils.InFilename1 = args[0];
        fileUtils.InFilename2 = args[1];
        fileUtils.OutFilename = args[2];
        //"./src/main/resources/TestTxt/orig.txt"
        String origin = fileUtils.read(fileUtils.InFilename1);
        String copy = fileUtils.read(fileUtils.InFilename2);

        SimHash hash1 = new SimHash(origin, 64);
        SimHash hash2 = new SimHash(copy, 64);
        int dis12 = hash1.getDistance(hash1.strSimHash, hash2.strSimHash);
        double rat2 = hash1.getSemblance(hash2);
        fileUtils.write(fileUtils.OutFilename, String.format("%.2f", rat2));
    }
}
