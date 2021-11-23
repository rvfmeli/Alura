package herdado;

public class TestaSistema {
    public static void main(String[] args) {


        Gerente gerente = new Gerente();
        gerente.setSenha(2222);

        SistemaInterno si = new SistemaInterno();
        si.autentica(gerente);

    }
}