import java.util.ArrayList;
import java.util.List;

public class Banco {
    private static int SEQUENCIAL = 1;
    private int codigo;
    private String nome;
    private List<Conta> contas = new ArrayList<>();
    private List<Cliente> clientes = new ArrayList<>();

    public Banco(String nome){
        this.nome = nome;
        this.codigo = SEQUENCIAL++;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void addConta(Conta conta){
        if(conta.getBanco() == this) {
            this.contas.add(conta);
            if(!this.clientes.contains(conta.cliente)){
                this.clientes.add(conta.cliente);
            }
        } else {
            System.out.println("Banco do cliente difere do banco em que a conta esta sendo adicionada. Operacao nao realizada");
        }
    }

    public void imprimeContas(){
        System.out.println("Contas do " + this.getNome() + ":");
        for(Conta conta: contas){
            System.out.print(conta +" | ");
        }
    }

    public void imprimeClientes(){
        System.out.println("Clientes do " + this.getNome() + ":");
        for(Cliente cliente: clientes){
            System.out.print(cliente.getNome() + "; ");
        }
    }

}
