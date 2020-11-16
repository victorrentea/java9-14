package victor.training.java11;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class FilesReadWrite {
   public static void main(String[] args) throws IOException {

      Files.writeString(Paths.get("test.txt"), "What\nduh");
//      IOUtils.writeString()
   }
}

