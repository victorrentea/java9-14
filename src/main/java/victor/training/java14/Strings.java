package victor.training.java14;

public class Strings {
   public static void main(String[] args) {
      String jude = "Hey Jude, don't make it bad\n" +
                    "Take a sad song and make it better\n" +
                    "Remember to let her into your heart\n" +
                    "Then you can start to make it better";
      jude = """
          Hey Jude, don't make it bad
          Take a sad song and make it better
          Remember to let her into your heart
          Then you can start to make it better""";
      System.out.println(jude.indent(3));
      // .isBlank 11
      // .indent
      // .lines 11
      // .repeat - do the same as .indent 11
      // .strip+ 11


      // text blocks
      // stripIndent

   }
}
