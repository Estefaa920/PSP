import java.io.File;
import java.io.IOException;
import java.nio.file.*;

public class Main  {
    public static void main(String[] args) {
        System.out.println();
        Path path = Paths.get(System.getProperty("user.dir"), "Files" );
        Path files[] = new Path[new File(path.toString()).list().length];
        int cont = 0;
        try (DirectoryStream<Path> stream = Files.newDirectoryStream(path)) {
            for (Path file: stream) {
                files[cont] = file;
                cont++;
            }
        } catch (IOException | DirectoryIteratorException x) {
            // IOException can never be thrown by the iteration.
            // In this snippet, it can only be thrown by newDirectoryStream.
            System.err.println(x);
        }

//        System.out.println(files[0]);
//        System.out.println(files[1]);
//        System.out.println(files[2]);
//        System.out.println(files[3]);


        Path file1 = files[0];
        Path file2= files[1];
        Path file3 = files[2];
        Path files4 = files[3];

        WordCounter wordCounter1 = new WordCounter(file1);
        wordCounter1.readFiles();
        WordCounter wordCounter2 = new WordCounter(file2);
        wordCounter2.readFiles();
        WordCounter wordCounter3 = new WordCounter(file3);
        wordCounter3.readFiles();
        WordCounter wordCounter4 = new WordCounter(files4);
        wordCounter4.readFiles();


    }
}
