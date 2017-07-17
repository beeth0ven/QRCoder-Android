package beeth0ven.tk.qrcoder.exframeworks.foundation.tuples;

public class Tuple<T0, T1> {

    public final T0 $0;
    public final T1 $1;

    private Tuple(T0 $0, T1 $1) {
        this.$0 = $0;
        this.$1 = $1;
    }

    public static <T0, T1> Tuple<T0, T1> create(T0 $0, T1 $1) {
        return new Tuple<>($0, $1);
    }
}
