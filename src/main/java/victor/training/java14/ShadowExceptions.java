package victor.training.java14;

import java.io.*;

public class ShadowExceptions {
   public static void main(String[] args) {
      try (CsvWriter c = new CsvWriter(new File("data.in"))) {

         if (true) {
            throw new IllegalCallerException("Business Exceptino (had to do with processing of the data)");
         }
      }
   }
}
class CsvWriter implements AutoCloseable {
   private final Writer writer;

   public CsvWriter(File file) {
      try {
         writer = new BufferedWriter(new FileWriter(file));
      } catch (IOException e) {
         throw new IllegalArgumentException(e);
      }

   }


   @Override
   public void close() {
//      try {
//         writer.close();
//      } catch (IOException e) {
//         throw new IllegalArgumentException(e);
//      }
      throw new IllegalArgumentException("Finally { Exception Tech ex had to do with some files gone, chmod, out of diskspace");
   }
}