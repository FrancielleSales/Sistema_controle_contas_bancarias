import java.util.Comparator;

public class ComparadorSaldoDec implements Comparator<Conta> {

    @Override
    public int compare(Conta c1, Conta c2) {
        if (c1.getSaldo() > c2.getSaldo()) {
            return -1;
        }

        if (c1.getSaldo() < c2.getSaldo()) {
            return 0;
        }

        return 1;
    }
}
