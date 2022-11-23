public class PessoaFisica extends Pessoa{

    private String cpf;
    private String dataNasc;
    private String rg;
    private float renda;

    public PessoaFisica(String cpf, String nome, String dataNasc, String rg, float renda) {
        super.setNome(nome);
        this.cpf = cpf;
        this.dataNasc = dataNasc;
        this.rg = rg;
        this.renda = renda;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getDataNasc() {
        return dataNasc;
    }

    public void setDataNasc(String dataNasc) {
        this.dataNasc = dataNasc;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public float getRenda() {
        return renda;
    }

    public void setRenda(float renda) {
        this.renda = renda;
    }

    @Override
    public String toString() {
        return "PessoaFisica{" +
                "cpf='" + cpf + '\'' +
                ", dataNasc='" + dataNasc + '\'' +
                ", rg='" + rg + '\'' +
                ", renda=" + renda + '\'' +
                ", nome='" + getNome() + '\'' +
                '}';
    }

    @Override
    public String getElementoInfo() {
        String tipo = "PessoaFisica";
        String cpf = "cpf=" + getCpf();
        String dataNascimento = "dataNascimento=" + getDataNasc();
        String rg = "rg=" + getRg();
        String renda = "renda=" + getRenda();
        String nome = "nome=" + getNome();



        String elementoInfo = tipo + "["
                + cpf + ", "
                + dataNascimento + ", "
                + rg + ", "
                + renda + ", "
                + nome + "]";

        return elementoInfo;
    }
}
