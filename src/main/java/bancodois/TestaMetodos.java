package bancodois;
public class TestaMetodos {
	public static void main(String[] args) {
		Contas contaDoPaulo = new Contas(6646,969060);
		contaDoPaulo.deposita(100);
		contaDoPaulo.deposita(50);
		System.out.println(contaDoPaulo.getSaldo());

		boolean conseguiuRetirar = contaDoPaulo.saca(20);
		System.out.println(contaDoPaulo.getSaldo());
		System.out.println(conseguiuRetirar);

		Contas contaDaMarcela = new Contas(6644,969063);
		contaDaMarcela.deposita(1000);

		boolean sucessoTransferencia = contaDaMarcela.transfere(300, contaDoPaulo);

		if (sucessoTransferencia) {
			System.out.println("transferencia com sucesso");

		} else {
			System.out.println("faltou dinheiro");

		}
		System.out.println(contaDaMarcela.getSaldo());
		System.out.println(contaDoPaulo.getSaldo());
	}

}