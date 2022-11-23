public class PessoaJuridica extends Pessoa{

    private String cnpj;
    private String cidade;
    private String estado;

    public PessoaJuridica(String cnpj, String nome, String cidade, String estado) {
        super.setNome(nome);
        this.cnpj = cnpj;
        this.cidade = cidade;
        this.estado = estado;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "PessoaJuridica{" +
                "cnpj='" + cnpj + '\'' +
                ", cidade='" + cidade + '\'' +
                ", estado='" + estado + '\'' +
                ", nome= '" + getNome() + '\'' +
                '}';
    }

    @Override
    public String getElementoInfo() {
        String tipo = "PessoaJuridica";
        String cnpj = "cnpj=" + getCnpj();
        String cidade = "cidade=" + getCidade();
        String estado = "estado=" + getEstado();
        String nome = "nome=" + getNome();

        String elementoInfo = tipo + "["
                + cnpj + ", "
                + cidade + ", "
                + estado + ", "
                + nome + "]";

        return elementoInfo;
    }
}
