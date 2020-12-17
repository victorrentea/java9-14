package victor.training.java14;

public class Strings {
   public static void main(String[] args) {
      String jude = """
            Hey Jude, don't make it bad
             Take a sad song and make it better
          Remember to let her into your heart
          Then you can start to make it better""";

      System.out.println(jude);
      // language=sql
      String sql = """
          SELECT aaa, asda,sad
          \t,bla blah
          FROM asdsad
          LEFT JOIN X
          WHERE
          IN
            (SELECT)
          """;

      // language=json
      String json = """
          {
            "key": 1,
            "value": 2
                    }
          """;


      // language=html
      String html = """
          <html>
          <body>
            <script</script>
                    </body>
          </html>
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

   public String method(int indent) {
//       String s= "";
//      for (int i = 0; i < indent; i++) {
//         s += " ";
//      }
      return " ".repeat(indent);
   }
}
