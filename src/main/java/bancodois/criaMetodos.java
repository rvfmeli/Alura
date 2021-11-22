package bancodois;
public class criaMetodos {
	public static void main(String[] args) {
		Clientes paulo = new Clientes();
		paulo.setNome("Paulo Silveira");
		paulo.setCpf("222.222.222.-22");
		paulo.setProfissao("programador");

		Contas contaDoPaulo = new Contas(6646,969060);
		contaDoPaulo.deposita(100);

		contaDoPaulo.setTitular(paulo);
		System.out.println(contaDoPaulo.getTitular().getNome());
		System.out.println(contaDoPaulo.getTitular());

	}
}