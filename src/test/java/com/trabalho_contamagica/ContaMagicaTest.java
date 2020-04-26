package com.trabalho_contamagica;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ContaMagicaTest {
    private ContaMagica contaComSaldo0;
    private ContaMagica contaComSaldo50000;
    private ContaMagica contaComSaldo200000;

    @BeforeEach
    public void setup(){
        //*** Inicializando Objetos para teste do método deposito() *** */
        contaComSaldo0 = new ContaMagica();
        contaComSaldo50000 = new ContaMagica();
        contaComSaldo200000 = new ContaMagica();

        /*Não precisararia setar o saldo da conta com 0 
        por que cada conta criada já inicia com saldo = 0 
        e status = SILVER.*/
        contaComSaldo0.setSaldo(0);

        /*Aqui, estamos setando o saldo = 50000 e estamos
        chamando o setStatus() para podermos simular
        que já foi feito pelo menos um depósito na conta.*/
        contaComSaldo50000.setSaldo(50000);
        contaComSaldo50000.setStatus();

        /*Aqui vamos criar uma conta com saldo = 200000 e
        simular pelo menos dois depósitos chamando o 
        setStatus() duas vezes para a conta ficar como PLATINUM.*/
        contaComSaldo200000.setSaldo(200000);
        contaComSaldo200000.setStatus();
        contaComSaldo200000.setStatus();

    }

    //**********  TESTANDO MÉTODOS DE DEPÓSITO P1 ************

    //Testando com depósito de R$1,00
    @Test
    public void test1(){
        try {
            contaComSaldo0.deposito(1);
            double saldo = contaComSaldo0.getSaldo();
            int status = contaComSaldo0.getStatus();
            assertEquals(1, saldo);
            assertEquals(0, status);
        } catch (Exception e) {
            System.out.println("Erro.");
            e.printStackTrace();
        }
    }

    //Testando com depósito de R$30.000
    @Test
    public void test2(){
        try {
            contaComSaldo0.deposito(30000);
            double saldo = contaComSaldo0.getSaldo();
            int status = contaComSaldo0.getStatus();
            assertEquals(30000, saldo);
            assertEquals(0, status);
        } catch (Exception e) {
            System.out.println("Erro.");
            e.printStackTrace();
        }
    }

    //Testando com depósito de R$49.999
    @Test
    public void test3(){
        try {
            contaComSaldo0.deposito(49999);
            double saldo = contaComSaldo0.getSaldo();
            int status = contaComSaldo0.getStatus();
            assertEquals(49999, saldo);
            assertEquals(0, status);
        } catch (Exception e) {
            System.out.println("Erro.");
            e.printStackTrace();
        }
    }

    // ******* FIM DOS TESTES DO MÉTODO DE DEPÓSITO P1 *********

    //___________________________________________________________

    //**********  TESTANDO MÉTODOS DE DEPÓSITO P2 ************

    //Testando com depósito de R$50.000
    @Test
    public void test4(){
        try {
            contaComSaldo0.deposito(50000);
            double saldo = contaComSaldo0.getSaldo();
            int status = contaComSaldo0.getStatus();
            assertEquals(50000, saldo);
            assertEquals(1, status);
        } catch (Exception e) {
            System.out.println("Erro.");
            e.printStackTrace();
        }
    }

     //Testando com depósito de R$199.999
     @Test
     public void test5(){
         try {
             contaComSaldo0.deposito(199999);
             double saldo = contaComSaldo0.getSaldo();
             int status = contaComSaldo0.getStatus();
             assertEquals(199999, saldo);
             assertEquals(1, status);
         } catch (Exception e) {
             System.out.println("Erro.");
             e.printStackTrace();
         }
     }

     // ******* FIM DOS TESTES DO MÉTODO DE DEPÓSITO P2 *********

    //___________________________________________________________

     //**********  TESTANDO MÉTODOS DE DEPÓSITO P3 ************

    //Testando com depósito de R$50.000
    @Test
    public void test6(){
        try {
            contaComSaldo0.deposito(200000);
            double saldo = contaComSaldo0.getSaldo();
            int status = contaComSaldo0.getStatus();
            assertEquals(200000, saldo);
            assertEquals(1, status);
        } catch (Exception e) {
            System.out.println("Erro.");
            e.printStackTrace();
        }
    }

    @Test
    public void test7(){
        try {
            contaComSaldo0.deposito(999999);
            double saldo = contaComSaldo0.getSaldo();
            int status = contaComSaldo0.getStatus();
            assertEquals(999999, saldo);
            assertEquals(1, status);
        } catch (Exception e) {
            System.out.println("Erro.");
            e.printStackTrace();
        }
    }

    // ******* FIM DOS TESTES DO MÉTODO DE DEPÓSITO P3 *********

    //___________________________________________________________

    //**********  TESTANDO MÉTODOS DE DEPÓSITO P4 ************

    //Testando com depósito de R$-1
    @Test
    public void test8(){
        try {
            contaComSaldo0.deposito(-1);
            double saldo = contaComSaldo0.getSaldo();
            int status = contaComSaldo0.getStatus();
            assertEquals(0, saldo);
            assertEquals(0, status);
        } catch (Exception e) {
            System.out.println("Erro.");
            e.printStackTrace();
        }
    }

    //Testando com depósito de R$-9999
    @Test
    public void test9(){
        try {
            contaComSaldo0.deposito(-9999);
            double saldo = contaComSaldo0.getSaldo();
            int status = contaComSaldo0.getStatus();
            assertEquals(0, saldo);
            assertEquals(0, status);
        } catch (Exception e) {
            System.out.println("Erro.");
            e.printStackTrace();
        }
    }

    // ******* FIM DOS TESTES DO MÉTODO DE DEPÓSITO P4 *********

    //___________________________________________________________

    //**********  TESTANDO MÉTODOS DE DEPÓSITO P5 ************

    //Testando com depósito de R$100
    @Test
    public void test10(){
        try {
            contaComSaldo50000.deposito(100);
            double saldo = contaComSaldo50000.getSaldo();
            int status = contaComSaldo50000.getStatus();
            assertEquals(50101, saldo);
            assertEquals(1, status);
        } catch (Exception e) {
            System.out.println("Erro.");
            e.printStackTrace();
        }
    }

    //Testando com depósito de R$148000
    @Test
    public void test11(){
        try {
            contaComSaldo50000.deposito(148000);
            double saldo = contaComSaldo50000.getSaldo();
            int status = contaComSaldo50000.getStatus();
            assertEquals(199480, saldo);
            assertEquals(1, status);
        } catch (Exception e) {
            System.out.println("Erro.");
            e.printStackTrace();
        }
    }

    // ******* FIM DOS TESTES DO MÉTODO DE DEPÓSITO P5 *********

    //___________________________________________________________

    //**********  TESTANDO MÉTODOS DE DEPÓSITO P6 ************
    
    //Testando com depósito de R$150000
    @Test
    public void test12(){
        try {
            contaComSaldo50000.deposito(150000);
            double saldo = contaComSaldo50000.getSaldo();
            int status = contaComSaldo50000.getStatus();
            assertEquals(201500, saldo);
            assertEquals(2, status);
        } catch (Exception e) {
            System.out.println("Erro.");
            e.printStackTrace();
        }
    }
        //Testando com depósito de R$999999
        @Test
        public void test13(){
            try {
                contaComSaldo50000.deposito(999999);
                double saldo = contaComSaldo50000.getSaldo();
                int status = contaComSaldo50000.getStatus();
                assertEquals(1059998.99, saldo);
                assertEquals(2, status);
            } catch (Exception e) {
                System.out.println("Erro.");
                e.printStackTrace();
            }
        }

    // ******* FIM DOS TESTES DO MÉTODO DE DEPÓSITO P6 *********

    //___________________________________________________________


    //**********  TESTANDO MÉTODOS DE DEPÓSITO P7 ************

    //Testando com depósito de R$-1
    @Test
    public void test14(){
        try {
            contaComSaldo50000.deposito(-1);
            double saldo = contaComSaldo50000.getSaldo();
            int status = contaComSaldo50000.getStatus();
            assertEquals(50000, saldo);
            assertEquals(1, status);
        } catch (Exception e) {
            System.out.println("Erro.");
            e.printStackTrace();
        }
    }

    //Testando com depósito de R$-9999
    @Test
    public void test15(){
        try {
            contaComSaldo50000.deposito(-9999);
            double saldo = contaComSaldo50000.getSaldo();
            int status = contaComSaldo50000.getStatus();
            assertEquals(50000, saldo);
            assertEquals(1, status);
        } catch (Exception e) {
            System.out.println("Erro.");
            e.printStackTrace();
        }
    }

        // ******* FIM DOS TESTES DO MÉTODO DE DEPÓSITO P7 *********

        //___________________________________________________________

        //**********  TESTANDO MÉTODOS DE DEPÓSITO P8 ************

        //Testando com depósito de R$100
        @Test
        public void test16(){
            try {
                contaComSaldo200000.deposito(100);
                double saldo = contaComSaldo200000.getSaldo();
                int status = contaComSaldo200000.getStatus();
                assertEquals(200102.5, saldo);
                assertEquals(2, status);
            } catch (Exception e) {
                System.out.println("Erro.");
                e.printStackTrace();
            }
        }
        
        //Testando com depósito de R$500000
        @Test
        public void test17(){
            try {
                contaComSaldo200000.deposito(500000);
                double saldo = contaComSaldo200000.getSaldo();
                int status = contaComSaldo200000.getStatus();
                assertEquals(712500, saldo);
                assertEquals(2, status);
            } catch (Exception e) {
                System.out.println("Erro.");
                e.printStackTrace();
            }
        }

        // ******* FIM DOS TESTES DO MÉTODO DE DEPÓSITO P8 *********

        //___________________________________________________________

        //*********  TESTANDO MÉTODOS DE RETIRADA/SAQUE P1 **********


}