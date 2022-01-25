public class Main {
    public static void main(String[] args) {
        Cliente cliente = new Cliente("Leonardo");
        Banco meuBanco = new Banco("Banco Carioca");

        ContaCorrente cc = new ContaCorrente(cliente, meuBanco);
        meuBanco.addConta(cc);
        cc.depositar(100);

        ContaPoupanca poupanca = new ContaPoupanca(cliente, meuBanco);
        meuBanco.addConta(poupanca);
        cc.transferir(50,poupanca);

        cc.imprimirExtrato();
        poupanca.imprimirExtrato();

        poupanca.renderMeses(5);
        poupanca.imprimirExtrato();

        meuBanco.imprimeContas();
        System.out.println("\n---");
        meuBanco.imprimeClientes();
    }
}
