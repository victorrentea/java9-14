package victor.training.java11;

public class PrivateDefault {

   public static void main(String[] args) {
      //
      ICommChanel smsChannel = new SmsChannel();
      smsChannel.sendAlert("Stay at home");
   }
}

interface ICommChanel {
   void sendMessage(String message);
   default void sendAlert(String message) {
      String alert = message.toUpperCase() + "!";
      sendMessage(alert);
   }
}

class SmsChannel implements ICommChanel {
   public void sendMessage(String message) {
      // TODO SMS
   }
}


// java7
interface Interface {
   public static final int CONSTANT = 1;
   public abstract void m();
   public abstract void stream(); // if List.stream were abstract, THOUSANDS of custom List impementations would have break

}


// java8
interface Interface2 {
   public static final int CONSTANT = 1;
   default void m() {
      // allow you to add behavior to all the implementers without breaking their implementation
      //logic here calling ***SOME*** instance method in there
   }
}

