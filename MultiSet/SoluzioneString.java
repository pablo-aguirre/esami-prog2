import java.util.Scanner;

/** Classe che implementa la lettura dei file di test. */
public final class SoluzioneString {

  private SoluzioneString() {
  }

  private static void print(StringMultiSet s) {
    System.out.println(s.size() + " " + s);
  }

  public static void main(String[] args) {
    final StringMultiSet a = new ListStringMultiSet(), b = new MapStringMultiSet();
    try (Scanner sc = new Scanner(System.in)) {
      try (Scanner fl = new Scanner(sc.nextLine())) {
        while (fl.hasNext())
          a.add(fl.next());
      }
      try (Scanner sl = new Scanner(sc.nextLine())) {
        while (sl.hasNext())
          b.add(sl.next());
      }
    }
    print(a);
    print(b);
    print(a.union(b));
    print(a.intersection(b));
  }
}