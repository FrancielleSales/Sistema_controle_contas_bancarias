import jdk.swing.interop.SwingInterOpUtils;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Conta {
    private int numero;
    private String dataAbertura;
    private boolean status;
    private String senha;
    private float saldo;
    private Pessoa donoDaConta;
    private String tipo;

    private List<String> movimentacoes = new ArrayList<>();

    public Conta(int numero, String tipo, String dataAbertura, boolean status, String senha, float saldo, Pessoa donoDaConta) {
        this.numero = numero;
        this.tipo = tipo;
        this.dataAbertura = dataAbertura;
        this.status = status;
        this.senha = senha;
        this.saldo = saldo;
        this.donoDaConta = donoDaConta;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String numero) {
        this.tipo = tipo;
    }

    public String getDataAbertura() {
        return dataAbertura;
    }

    public void setDataAbertura(String dataAbertura) {
        this.dataAbertura = dataAbertura;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public float getSaldo() {
        return saldo;
    }

    public void setSaldo(float saldo) {
        this.saldo = saldo;
    }

    public Pessoa getDonoDaConta() {
        return donoDaConta;
    }

    public void setDonoDaConta(Pessoa donoDaConta) {
        this.donoDaConta = donoDaConta;
    }

    public List<String> getMovimentacoes() {
        return movimentacoes;
    }

    public void setMovimentacoes(List<String> movimentacoes) {
        this.movimentacoes = movimentacoes;
    }

    @Override
    public String toString() {
        return "Conta{" +
                "numero=" + numero +
                ", dataAbertura='" + dataAbertura + '\'' +
                ", status=" + status +
                ", senha='" + senha + '\'' +
                ", saldo=" + saldo +
                ", donoDaConta=" + donoDaConta +
                '}';
    }

    public String statusConta() {
        if (status == true) {
            String statusConta = "Ativa";
            return statusConta;
        } else {
            String statusConta = "Inativa";
            return statusConta;
        }
    }

    public void saque(float valorSaque) {

        if (saldo >= valorSaque) {
            saldo -= valorSaque;

            String movimentacao = "Saque    " + valorSaque;

            movimentacoes.add(movimentacao);
        } else {
            System.out.println("Saldo insuficiente!");
        }
    }

    public void deposito(float valorDeposito) {
        saldo += valorDeposito;

        String movimentacao = "Depósito    " + valorDeposito;

        movimentacoes.add(movimentacao);
    }

    public void atualizaTaxa (){
        saldo -= 20;

        String movimentacao = "Taxa    " + "20";

        movimentacoes.add(movimentacao);
    }

    public BigDecimal rendimento(){
        return BigDecimal.ZERO;
    }

    List<Conta> contas = new LinkedList<Conta>();
    public List<Conta> getContas() {
        return contas;
    }

    public void relatorio() {
        System.out.println("Conta: " + numero);
        System.out.println("Tipo: " + tipo);
        System.out.println("Abertura: " + dataAbertura);
        System.out.println("Status: " + statusConta());
        System.out.println("Titular: " + donoDaConta);
        System.out.println("Movimentos: ");

        for(int i = 0; i < getMovimentacoes().size(); i++){
            System.out.println(i + 1 + "    " + getMovimentacoes().get(i));
        }

        System.out.println("Saldo: " + saldo);

        if (getTipo().equals("Conta Poupança")) {
            System.out.println("Rendimentos: " + rendimento());
        }
    }

}
