package beeth0ven.tk.qrcoder.exframeworks.foundation.tuples;

public class Tuple5<T0, T1, T2, T3, T4> {

    public final T0 $0;
    public final T1 $1;
    public final T2 $2;
    public final T3 $3;
    public final T4 $4;

    private Tuple5(T0 $0, T1 $1, T2 $2, T3 $3, T4 $4) {
        this.$0 = $0;
        this.$1 = $1;
        this.$2 = $2;
        this.$3 = $3;
        this.$4 = $4;
    }

    public static <T0, T1, T2, T3, T4> Tuple5<T0, T1, T2, T3, T4> create(T0 $0, T1 $1, T2 $2, T3 $3, T4 $4) {
        return new Tuple5<>($0, $1, $2, $3, $4);
    }
}
