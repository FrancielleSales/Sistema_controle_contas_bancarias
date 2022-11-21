public class ContaEspecial extends Conta {

    private float limite;

    // conta especial = {numero, data abertura, status, senha, saldo, limite, dono da conta
    public ContaEspecial(int numero,String tipo, String dataAbertura, boolean status, String senha,
                         float saldo, float limite, Pessoa donoDaConta) {
        super(numero, tipo, dataAbertura, status, senha, saldo, donoDaConta);
        this.limite = limite;
    }

    public float getLimite() {
        return limite;
    }

    public void setLimite(float limite) {
        this.limite = limite;
    }

    @Override
    public String toString() {
        return "ContaEspecial{" +
                "limite=" + limite +
                '}';
    }
    @Override
    public void saque(float valorSaque) {

        float saldo = getSaldo();
        float maximo = limite + saldo;

        if (maximo >= valorSaque) {
            saldo -= valorSaque;

            setSaldo(saldo);

            String movimentacao = "Saque    " + valorSaque;

            getMovimentacoes().add(movimentacao);
        } else {
            System.out.println("Limite ultrapassado!");
        }
    }
    @Override
    public void atualizaTaxa (){

        float antigoSaldo = getSaldo();
        float novoSaldo = antigoSaldo - 30;

        setSaldo(novoSaldo);

        String movimentacao = "Taxa    " + "30";

        getMovimentacoes().add(movimentacao);
    }
}
