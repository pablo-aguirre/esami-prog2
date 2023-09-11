import java.util.Scanner;

public class Test {
    public static void main(String[] args) throws Exception {
        final SistemaAstronomico sa = new SistemaAstronomico();

        try (Scanner s = new Scanner(System.in)) {
            while (s.hasNextLine()) {
                if (s.next().equals("P"))
                    sa.aggiungi(new Pianeta(s.next(), s.nextInt(), s.nextInt(), s.nextInt()));
                else
                    sa.aggiungi(new StellaFissa(s.next(), s.nextInt(), s.nextInt(), s.nextInt()));
            }
        }

        sa.simula(Integer.parseInt(args[0]));
        System.out.println(sa);
        System.out.println("Energia totale: " + sa.energia());
    }
}