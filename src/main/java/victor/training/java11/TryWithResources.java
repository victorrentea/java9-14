package victor.training.java11;

import java.io.InputStream;
import java.io.Reader;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.toList;

public class TryWithResources {
   public void checkFile(Stream<String> lines) { // e considerat un pic fishy sa transm un Stream param. Daca-l consumi il termini
      // un stream trebuie inchis daca se mapeaza pe linii de fisier sau resultseturi din DB
      try (lines) { // dubios pentru ca inchizi o resursa deja creeata.
         // Mai corect este ca de la creere sa si declari scope-ul dupa care se inchide
         if (lines.filter(s -> !s.isBlank()).count() <= 20) {
            throw new IllegalArgumentException("Incorrect file!");
         }
      }
   }
}
