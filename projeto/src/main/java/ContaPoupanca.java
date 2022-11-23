import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

public class ContaPoupanca extends Conta {

    private int diaAniversario;

    // conta poupanca = {numero, data abertura, status, senha, saldo, dia aniversario, dono da conta

    public ContaPoupanca(int numero, String tipo, String dataAbertura, boolean status, String senha,
                         float saldo, int diaAniversario, Pessoa donoDaConta) {
        super(numero, tipo, dataAbertura, status, senha, saldo, donoDaConta);
        this.diaAniversario = diaAniversario;
    }

    public int getDiaAniversario() {
        return diaAniversario;
    }

    public void setDiaAniversario(int diaAniversario) {
        this.diaAniversario = diaAniversario;
    }

    @Override
    public String toString() {
        return "ContaPoupanca{" +
                "diaAniversario='" + diaAniversario + '\'' +
                '}';
    }

    @Override
    public void atualizaTaxa() {
        float antigoSaldo = getSaldo();
        float novoSaldo = antigoSaldo * 1.005f;

        setSaldo(novoSaldo);

        String tipoMovimentacao = "Juros";
        getTipoMovimentacoes().add(tipoMovimentacao);

        String movimentacao = "" + antigoSaldo * 0.005f;
        getMovimentacoes().add(movimentacao);
    }

    @Override
    public BigDecimal rendimento() {

        float saldo = getSaldo();
        float rendimentos = saldo * 0.005f;

        BigDecimal bd = new BigDecimal(rendimentos).setScale(1, RoundingMode.HALF_EVEN);

        return bd;
    }

    @Override
    public String getElementoInfo() {
        String tipo = "ContaPoupanca";
        String diaAniversario = "diaAniversario" + getDiaAniversario();
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
                + diaAniversario + ", "
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
