package iniciante;

public class Tabuada {

    public static void main(String[] args) {

        int contador = 0;
        int multiplicador = 0;

        for (contador = 0; contador < 10; contador++) {
            for (multiplicador = 0; multiplicador < 10; multiplicador++) {
                System.out.println("é:  " + contador * multiplicador);
            }

            System.out.println();
        }

    }
}
