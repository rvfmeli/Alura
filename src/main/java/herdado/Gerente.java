package herdado;

//Gerente é um funcionario e herda a classe FuncionarioAutential
public class Gerente extends FuncionarioAutenticavel {
	
	private int senha;

	public double getBonificacao() {
		System.out.println("Chamando o método de bonificacao do GERENTE");
		return super.getSalario();
	}

	public void setSenha(int senha) {
		this.senha = senha;
	}

	public boolean autentica(int senha) {
		if(this.senha == senha){
			return true;
		} else {
			return false;
		}
	}

}
