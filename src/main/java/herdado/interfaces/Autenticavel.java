package herdado.interfaces;

//contrato autenticavel
//quem assinar esse contrato, precisar implementar
// metodo senha e metodo autentica

public abstract interface Autenticavel {
    public abstract void setSenha(int senha);
    public abstract boolean setAutentica (int autentica);


}
