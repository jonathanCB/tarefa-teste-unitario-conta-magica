package com.trabalho_contamagica;

public class ContaMagica {
    public static final int SILVER = 0;
    public static final int GOLD = 1;
    public static final int PLATINUM = 2;
    private int saldo;
    private int status;
    
    public int getSaldo() {
        return this.saldo;
    }

    public void setSaldo(int saldo) {
        this.saldo = saldo;
    }

    public int getStatus() {
        return this.status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public void deposito(int valor) throws OperacaoInvalidaException {
        this.setSaldo(this.getSaldo() + valor);
    }

    public void retirada(int valor) throws OperacaoInvalidaException {
        this.setSaldo(this.getSaldo() - valor);
    }
}