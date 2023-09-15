import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/** La classe di <em>test</em>. */
public class Soluzione {

  public static void main(String[] args) {
    try (final Scanner s = new Scanner(System.in)) {
      final List<Superficie> rivestimento = new ArrayList<>();
      final List<PavimentazioneBis> pavimentazione = new ArrayList<>();
      while (s.hasNextLine())
        try (final Scanner line = new Scanner(s.nextLine())) {
          switch (line.next().charAt(0)) {
            case 'Q':
              rivestimento.add(new PiastrellaQuadrata(line.nextInt(), line.nextInt()));
              break;
            case 'R':
              rivestimento.add(
                  new PiastrellaRomboidale(line.nextInt(), line.nextInt(), line.nextInt()));
              break;
            case 'T':
              rivestimento.add(
                  new PiastrellaTriangolare(line.nextInt(), line.nextInt(), line.nextInt()));
              break;
            case 'P':
              final List<PavimentazioneBis.Componente> componenti = new ArrayList<>();
              while (line.hasNextInt())
                componenti.add(
                    new PavimentazioneBis.Componente(
                        line.nextInt(), rivestimento.get(line.nextInt())));
              final PavimentazioneBis p = new PavimentazioneBis(componenti);
              pavimentazione.add(p);
              rivestimento.add(p);
              break;
            default:
              throw new IllegalArgumentException("Errore nel formato.");
          }
        }
      for (final PavimentazioneBis p : pavimentazione)
        System.out.println(p.superficie() + "\t" + p.costo());
    }
  }
}