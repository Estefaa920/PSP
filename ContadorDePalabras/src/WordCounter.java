import java.io.*;
import java.nio.file.Path;


public class WordCounter extends Thread{

    private Path path;
    private int cont=0;
    private String spaces;
    private Path files;
    private  String otherLine = " ";

    public WordCounter(Path files){
        this.files = files;
    }

    public int count( String spaces){

        for (int i = 0; i < spaces.split(otherLine).length ; i++) {

                cont++;

        }
            return cont;
    }


    public void readFiles(){



        try{
            BufferedReader reader = new BufferedReader(new FileReader(String.valueOf(files)));


            while((spaces = reader.readLine()) != null){

               count(spaces);

            }

        }catch(Exception e){
            System.err.println("No se ha encontrado el archivo");
        }
      System.out.print( "File " + files.getFileName()+ " has " + cont + "\n");

    }


}


