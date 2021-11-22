package bancodois;
public class TesteSacaNeagivos {
	public static void main(String[] args) {
		Contas conta = new Contas(6646,969060);
		conta.deposita(100);
		System.out.println(conta.saca(101));

		conta.saca(101);

		System.out.println(conta.getSaldo());

	}
}