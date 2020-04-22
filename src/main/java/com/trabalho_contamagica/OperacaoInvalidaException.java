package com.trabalho_contamagica;

public class OperacaoInvalidaException extends Exception{
    private int valor;

    public OperacaoInvalidaException(int valor){
        super();
        this.valor = valor;
    }

    @Override
    public String toString() {
        return "O valor " + this.valor + " nao e valido.";
    }
   
}