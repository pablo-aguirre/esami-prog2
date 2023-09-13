import java.util.Scanner;

public class Soluzione {

  public static Matrice valueOf(final char tipo, final int[][] arr) {
    switch (tipo) {
      case ' ':
        return new MatriceDensa(arr);
      case 'Z':
        return new MatriceNulla(arr[0][0]);
      case 'I':
        return new MatriceIdentità(arr[0][0]);
      case 'D':
        return new MatriceDiagonale(arr[0]);
    }
    throw new IllegalArgumentException("Tipo non riconosciuto.");
  }

  public static void main(String[] args) {
    try (final Scanner s = new Scanner(System.in)) {
      while (s.hasNextLine()) {
        final String[] lor = Parser.partiOperazione(s.nextLine());
        final char op = lor[1].charAt(0);
        final String left = lor[0], right = lor[2];
        if (op == '+') {
          if (Parser.èVettore(left) && Parser.èVettore(right)) {
            Vettore u = new VettoreDenso(Parser.valoriVettore(left));
            Vettore v = new VettoreDenso(Parser.valoriVettore(right));
            System.out.println(u.più(v));
          } else if (Parser.èMatrice(left) && Parser.èMatrice(right)) {
            Matrice M = valueOf(Parser.tipoMatrice(left), Parser.valoriMatrice(left));
            Matrice N = valueOf(Parser.tipoMatrice(right), Parser.valoriMatrice(right));
            System.out.println(M.più(N));
          }
        } else { // op == '*', altrimenti partiOperazione solleva eccezione
          if (Parser.èScalare(left)) {
            int alpha = Parser.valoreScalare(left);
            if (Parser.èVettore(right)) {
              Vettore v = new VettoreDenso(Parser.valoriVettore(right));
              System.out.println(v.per(alpha));
            } else if (Parser.èMatrice(right)) {
              Matrice M = valueOf(Parser.tipoMatrice(right), Parser.valoriMatrice(right));
              System.out.println(M.per(alpha));
            }
          } else if (Parser.èMatrice(left)) {
            Matrice M = valueOf(Parser.tipoMatrice(left), Parser.valoriMatrice(left));
            if (Parser.èMatrice(right)) {
              Matrice N = valueOf(Parser.tipoMatrice(right), Parser.valoriMatrice(right));
              System.out.println(M.per(N));
            } else if (Parser.èVettore(right)) {
              Vettore v = new VettoreDenso(Parser.valoriVettore(right));
              System.out.println(M.per(v));
            }
          }
        }
      }
    }
  }
}