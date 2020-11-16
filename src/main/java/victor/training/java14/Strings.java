package victor.training.java14;

public class Strings {
//   @Query("""
//          SELECT t
//          FROM Teacher t
//          LEFT JOIN FETCH t.students""")

   public static void main(String[] args) {
      String jude = """
          { "asss": "in sfarsit" } %s 
          SELECT t
          FROM Teacher t
          LEFT JOIN FETCH t.students

           Hey Jude, don't make it bad
          Take a sad song and make it better
          Remember to let her into your heart
          Then you can start to make it better""".formatted("Param");

      System.out.println(jude);


      System.out.printf("asada %s end%n", 1);

//      "\t\njude".trim()
      ;
      System.out.println(" ".repeat(3) + "public static void m() {}");
      System.out.println(jude.lines().count() + " lines");
      // .isBlank 11
      // .indent
      // .lines 11
      // .repeat - do the same as .indent 11
      // .strip+ 11


      // text blocks
      // stripIndent
      // .formatted
      // \
      // <trailingspace>\s

   }

}
