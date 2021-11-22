package carro;

public class Carro {

    public static void main(String[] args) {

    }

    private int ano;
    private String modelo;
    private double preco;

    // Carro carro = new Carro(int ano, String modelo, double preco);

//    public Carro(int ano, String moddlo, double preco){
//        this.ano = 2013;
//        this.modelo = "gol";
//        this.preco = 35000;
//    }

    public Carro(int ano, String modelo, double preco) {
        if (ano >= 1891) {
            this.ano = ano;
        } else {
            System.out.println("o ano informado está invalido");
            this.ano = 2017;
        }
        if (modelo != null) {
            this.modelo = modelo;
        } else {
            System.out.println("O modelo não foi informado. Por isso usaremos Gol!");
            this.modelo = "Gol";
        }

        if (preco > 0) {
            this.preco = preco;
        } else {
            System.out.println("O preço não é válido. Por isso usaremos 40000.0!");
            this.preco = 40000.0;
        }
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;

    }
}
