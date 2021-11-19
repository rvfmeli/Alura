import banco.Cliente;
import banco.Conta;

public class TestaMetodo {

    public static void main(String[] args) {

        Conta conta = new Conta();
        Conta contaDoPaulo = new Conta();
        contaDoPaulo.saldo = 100;
        contaDoPaulo.deposita(50);
        System.out.println(contaDoPaulo.saldo);

        boolean conseguiuRetirar = contaDoPaulo.saca(20);
        System.out.println(contaDoPaulo.saldo);
        System.out.println(conseguiuRetirar);

        Conta contaDaMarcela = new Conta();
        contaDaMarcela.deposita(1000);

        boolean sucessoTransferencia = contaDaMarcela.transfere(300, contaDoPaulo);

        if (sucessoTransferencia) {
            System.out.println("transferencia com sucesso");

        } else {
            System.out.println("faltou dinheiro");

        }
        System.out.println(contaDaMarcela.saldo);
        System.out.println(contaDoPaulo.saldo);


        Cliente paulo = new Cliente();
        paulo.setNome("paulo silveira");
        System.out.println(conta.getTitular());

        System.out.println(conta.getTitular());
    }
}