package oppg19_10;
import java.io.*;
import java.util.*;
/**
 * Created with IntelliJ IDEA.
 * User: Marko Sundic
 * Student nr. 530 614
 */


public class FileSplitter {

    /**
     To run this program it needs 2 arguments
     1. Path to the file
     2. ammount of wanted parts document should be split into.
     */

    public static void main(String[] args) throws IOException {

        // The program needs to be executed with two parameters in order to
        // work. This sentence check for it.
        if (args.length != 2) {
            System.out.println("Usage: source file and number of wanted files it should be split to, need to be added as parameters");
            System.exit(1);
        }
        // Check whether or not the sourcefile exists
        File sourceFile = new File(args[0]);
        if (!sourceFile.exists()) {
            System.out.println("Source file " + args[0] + " does not exist");
            System.exit(2);
        }
        // Array to save the files that are being split
        ArrayList<File> fileArray = new ArrayList<>();


        ArrayList<BufferedOutputStream> outputArray = new ArrayList<>();


        RandomAccessFile inOutSourceFile = new RandomAccessFile(sourceFile,
                "rw");


        for (int i = 0; i < Integer.parseInt(args[1]); i++) {
            String nameAppender = String.valueOf(i);
            String nameBuilder;
            int suffix = args[0].indexOf(".");
            nameBuilder = args[0].substring(0, suffix);
            fileArray.add((new File(nameBuilder + nameAppender + ".n")));
        }


        for (int i = 0; i < Integer.parseInt(args[1]); i++) {
            outputArray.add(new BufferedOutputStream(new FileOutputStream(
                    new File(fileArray.get(i).getAbsolutePath()))));
        }


        float size = inOutSourceFile.length();
        double parts = Integer.parseInt(args[1]);
        double partSize = size / parts;
        int r;



        for (int i = 1; i <= parts; i++) {
            while (inOutSourceFile.getFilePointer() < partSize * i) {
                r = inOutSourceFile.readByte();
                outputArray.get(i - 1).write((byte) r);
            }

        }

        inOutSourceFile.close();
        for (int i = 0; i < parts; i++) {
            outputArray.get(i).close();
        }

        // Display the operations
        System.out.println(args[0] + " Split into " + args[1]
                + " parts. " + "\n" + "Size of each part is " + partSize
                + " Bytes");

    }

}
