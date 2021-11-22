package bancodois;


public class TestaContaSemClientes {
	public static void main(String[] args) {
		Contas contaDaMarcela = new Contas(6646,969060);
		System.out.println(contaDaMarcela.getSaldo());

		contaDaMarcela.setTitular(new Clientes());
		System.out.println(contaDaMarcela.getTitular());

		contaDaMarcela.getTitular().setNome("Marcela");
		System.out.println(contaDaMarcela.getTitular().getNome());

	}
}