import java.math.BigDecimal;
import java.math.RoundingMode;

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

        String movimentacao = "Juros    " + antigoSaldo * 0.005f;

        getMovimentacoes().add(movimentacao);
    }

    @Override
    public BigDecimal rendimento() {

        float saldo = getSaldo();
        float rendimentos = saldo * 0.005f;

        BigDecimal bd = new BigDecimal(rendimentos).setScale(1, RoundingMode.HALF_EVEN);

        return bd;
    }
}
