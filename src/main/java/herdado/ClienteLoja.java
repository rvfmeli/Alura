package herdado;

import herdado.interfaces.Autenticavel;

public class ClienteLoja implements Autenticavel {

    private int senha;

    @Override
    public void setSenha(int senha) {
        this.senha = senha;
    }


    @Override
    public boolean setAutentica (int senha){
    if ( this.senha == senha) {
        return true;
    } else {
        return false;
        }
    }
}
