import java.util.List;

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

            String tipoMovimentacao = "Saque";
            getTipoMovimentacoes().add(tipoMovimentacao);

            String movimentacao = "20";
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

        String tipoMovimentacao = "Taxa";
        getTipoMovimentacoes().add(tipoMovimentacao);

        String movimentacao = "20";
        getMovimentacoes().add(movimentacao);
    }

    @Override
    public String getElementoInfo() {
        String tipo = "ContaEspecial";
        String limite = "limite=" + getLimite();
        String numero = "numero=" + getNumero();
        String dataAbertura = "dataAbertura=" + getDataAbertura();
        String status = "status=" + isStatus();
        String senha = "senha=" + getSenha();
        String saldo = "saldo=" + getSaldo();
        String titular = "titular=" + getDonoDaConta();

        String movimentos ="";
        for (int i = 0; i < getMovimentacoes().size(); i++) {
            if (i < getMovimentacoes().size() -1) {
                movimentos = movimentos
                        + "Movimento [tipo=" + getTipoMovimentacoes().get(i)
                        + ", valor=" + getMovimentacoes().get(i) + "], ";
            } else {
                movimentos = movimentos
                        + "Movimento [tipo=" + getTipoMovimentacoes().get(i)
                        + ", valor=" + getMovimentacoes().get(i) + "]";
            }
        }

        String elementoInfo = tipo + "["
                + limite + ", "
                + numero + ", "
                + dataAbertura + ", "
                + status + ", "
                + senha + ", "
                + saldo + ", "
                + titular + ", "
                + "movimentos=[" + movimentos + "]]";

        return elementoInfo;
    }

}
