package beeth0ven.tk.qrcoder.exframeworks.foundation.tuples;

public class Tuple4<T0, T1, T2, T3> {

    public final T0 $0;
    public final T1 $1;
    public final T2 $2;
    public final T3 $3;

    private Tuple4(T0 $0, T1 $1, T2 $2, T3 $3) {
        this.$0 = $0;
        this.$1 = $1;
        this.$2 = $2;
        this.$3 = $3;
    }

    public static <T0, T1, T2, T3> Tuple4<T0, T1, T2, T3> create(T0 $0, T1 $1, T2 $2, T3 $3) {
        return new Tuple4<>($0, $1, $2, $3);
    }
}
