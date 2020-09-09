package victor.training.java14;

public class Strings {
   public static void main(String[] args) {
      String jude = """
             Hey Jude, don't make it bad
               Take a sad song and make it better
            Remember to let her into your heart
             Then you can start to make it better""";
      String jude2 = "  Hey Jude, don't make it bad\n" +
                     "   Take a sad song and make it better\n" +
                     "Remember to let her into your heart\n" +
                     " Then you can start to make it better\n" +
                     " asd\n" +
                     " sadsa\n" +
                     " sadsa";

      System.out.println(jude);

//      String padding = "";
//      for (int i = 0; i < 3; i++) {
//         padding += " ";
//      }
//      String padding = " x".repeat(3);
      String padding = String.format("%3s"," ");
      System.out.println(padding + "code");

      String sqlQuery = """       
          SELECT stu   FROM stuff 
          LEFT JOIN child on child.parent_id----
          WHERE""";

      // language=json
      String json = """
          {
            "field":1,
            "two":2
          }
          """;

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
