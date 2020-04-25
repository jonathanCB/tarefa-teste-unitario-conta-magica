package com.trabalho_contamagica;

public class ContaMagica {
    public static final int SILVER = 0;
    public static final int GOLD = 1;
    public static final int PLATINUM = 2;
    private double saldo;
    private int status;
    
    public ContaMagica() {
        this.saldo = 0;
        this.status = SILVER;
    }
    
    public double getSaldo() {
        return this.saldo;
    }

    public int getStatus() {
        return this.status;
    }

    public void setStatus() {
        if ((this.getSaldo() >= 50000 && this.getStatus() == this.SILVER) || (this.getSaldo() < 100000 && this.getStatus() == this.PLATINUM)) {
            this.status = this.GOLD;
        } else if (this.getSaldo() >= 200000 && this.getStatus() == this.GOLD) {
            this.status = this.PLATINUM;
        } else if (this.getSaldo() < 25000 && this.getStatus() == this.GOLD) {
            this.status = this.SILVER;
        } else {
            this.status = this.getStatus();
        }
    }

    public void deposito(int valor) throws OperacaoInvalidaException{
        try {
            if (this.getStatus() == this.SILVER && valor >= 0) {
                this.saldo = this.getSaldo() + valor;
                setStatus();
            } else if (this.getStatus() == this.GOLD && valor >= 0) {
                this.saldo = this.getSaldo() + valor + (valor * 0.01);
                setStatus();
            } else if (this.getStatus() == this.PLATINUM && valor >= 0) {
                this.saldo = this.getSaldo() + valor + (valor * 0.025);
                setStatus();
            } else {
                throw new OperacaoInvalidaException(valor);
            }
        } catch (OperacaoInvalidaException e) {
            System.out.println("Ocorreu um erro ao depositar esse valor.");
            e.printStackTrace();
        }
    }

    public void retirada(int valor) throws OperacaoInvalidaException {
        try {
            if (valor >= 0 && valor <= this.getSaldo()) {
                if (this.getStatus() >= this.SILVER && this.getStatus() <= this.PLATINUM) {
                    this.saldo = this.getSaldo() - valor;
                    setStatus();
                }
            } else {
                throw new OperacaoInvalidaException(valor);
            }
        } catch (OperacaoInvalidaException e) {
            System.out.println("Ocorreu um erro ao retirar esse valor.");
            e.printStackTrace();
        }
    }

    @Override
    public String toString() {
        return "ContaMagica [saldo= R$" + saldo + ", status=" + status + "]";
    }

}