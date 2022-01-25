public class ContaPoupanca extends Conta{

    private static double RENDIMENTO_POUPANCA = 0.08;

    public ContaPoupanca(Cliente cliente, Banco banco){
        super(cliente, banco);
    }

    public void renderMeses(int qtdMeses){
        if(qtdMeses <= 12 && qtdMeses >= 1){
            double montante = this.getSaldo() * Math.pow((1+RENDIMENTO_POUPANCA),(double) qtdMeses);
            double rendimento = montante-this.getSaldo();
            this.depositar(rendimento);
            System.out.println(String.format("Sua poupanca rendeu R$ %.2f em %d meses.", rendimento, qtdMeses));
        } else {
            System.out.println("Quantidade de meses invalida.");
        }
    }

    public void imprimirExtrato() {
        System.out.println("--- Extrato conta poupanca ---");
        super.imprimirInfosComuns();
    }



}
