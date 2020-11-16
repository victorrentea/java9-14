package victor.training.java11;

public class PrivateDefault {

   public static void main(String[] args) {
      //

   }
}

interface ICommChanel {
   void sendMessage(String message);
   void sendAlert(String alert);
}

abstract class AbstractChannel implements ICommChanel {
   public void sendAlert(String alert) {
       sendMessage(alert.toUpperCase() + "!");
   }
}

class SmsChannel extends AbstractChannel implements ICommChanel {
   @Override
   public void sendMessage(String message) {

   }
}
class EmailChannel extends AbstractChannel implements ICommChanel {
   @Override
   public void sendMessage(String message) {

   }
}