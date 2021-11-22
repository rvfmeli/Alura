package bancodois;
public class CriaContas {

    public static void main(String[] args) {
        Contas primeiraConta = new Contas(6646,969060);
        primeiraConta.deposita(200);
        System.out.println(primeiraConta.getSaldo());

        primeiraConta.deposita(100);
        System.out.println(primeiraConta.getSaldo());

        Contas segundaConta = new Contas(6645,969061);
        segundaConta.deposita(50);

        System.out.println("primeira conta tem " + primeiraConta.getSaldo());
        System.out.println("segunda conta tem " + segundaConta.getSaldo());

        System.out.println("referenciar: " + primeiraConta);
    }

}