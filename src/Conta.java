public class Conta {
    private String agencia;
    private int numero;
    private double saldo;
    private Cliente titular;

    public Conta(String agencia, int numero, double saldo, Cliente titular) {
        this.agencia = agencia;
        this.numero = numero;
        this.saldo = saldo;
        this.titular = titular;
    }

    public void deposita(double valor) {
        this.saldo += valor;
    }
    public boolean saca(double valor) {
        if (this.saldo >= valor) {
            this.saldo -= valor;
            return true;
        } else {
            return false;
        }
    }
    public boolean transfere(double valor, Conta destino) {
        if (this.saldo >= valor) {
            this.saldo -= valor;
            destino.deposita(valor);
            return true;
        } else {
            return false;

        }
    }
    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        if (numero <= 0)
            System.out.println("Número inválido, número deve ser maior que zero");
        this.numero = numero;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public String getAgencia() {
        return agencia;
    }

    public void setAgencia(String agencia) {
        if (numero <= 0)
            System.out.println("Número inválido, número deve ser maior que zero");
        this.agencia = agencia;
    }

    public Cliente getTitular() {
        return titular;
    }

    public void setTitular(Cliente titular) {
        this.titular = titular;
    }



}
