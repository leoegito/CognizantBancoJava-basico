public abstract class Conta implements iConta{

    private static int AGENCIA_PADRAO = 1;
    private static int SEQUENCIAL = 1;

    protected int agencia;
    protected int numero;
    protected double saldo;

    protected Cliente cliente;
    protected Banco banco;

    public Banco getBanco() {
        return this.banco;
    }

    public Conta(Cliente cliente, Banco banco) {
        this.agencia = Conta.AGENCIA_PADRAO;
        this.numero = SEQUENCIAL++;
        this.cliente = cliente;
        this.banco = banco;
    }

    protected void imprimirInfosComuns() {
        System.out.println("Titular: " + this.cliente.getNome());
        System.out.println(String.format("Agencia: %d", this.getAgencia()));
        System.out.println(String.format("Conta: %d", this.getNumero()));
        System.out.println(String.format("Saldo: %.2f", this.getSaldo()));
    }

    public boolean validaValor(double valor){
        if(valor < 0d){
            return false;
        }
        return true;
    }
    public boolean validaOperacao(double valor){
        if(this.getSaldo() >= valor)
            return true;
        return false;
    }

    public void sacar(double valor){
        if(validaValor(valor)){
            if(validaOperacao(valor)) {
                this.saldo -= valor;
            } else {
                System.out.println("Saldo insuficiente.");
            }
        } else {
            System.out.println("Valor invalido informado.");
        }
    }

    public void depositar(double valor){
        this.saldo += valor;
    }

    public void transferir(double valor, Conta contaDestino){
        if(validaOperacao(valor) && validaValor(valor)){
            contaDestino.depositar(valor);
        } else {
            System.out.println("Transferencia invalida.");
        }
    }

    public int getAgencia() {
        return agencia;
    }

    public int getNumero() {
        return numero;
    }

    public double getSaldo() {
        return saldo;
    }

    @Override
    public String toString(){
        String str = "";
        str += "Agencia: " +this.getAgencia();
        str += " Conta: " +this.getNumero();
        str += " Cliente: " +this.cliente.getNome();
        return str;
    }

}
