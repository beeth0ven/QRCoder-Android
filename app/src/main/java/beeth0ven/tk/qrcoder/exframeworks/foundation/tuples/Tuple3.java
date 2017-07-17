package beeth0ven.tk.qrcoder.exframeworks.foundation.tuples;

public class Tuple3<T0, T1, T2> {

    public final T0 $0;
    public final T1 $1;
    public final T2 $2;

    private Tuple3(T0 $0, T1 $1, T2 $2) {
        this.$0 = $0;
        this.$1 = $1;
        this.$2 = $2;
    }

    public static <T0, T1, T2> Tuple3<T0, T1, T2> create(T0 $0, T1 $1, T2 $2) {
        return new Tuple3<>($0, $1, $2);
    }
}
