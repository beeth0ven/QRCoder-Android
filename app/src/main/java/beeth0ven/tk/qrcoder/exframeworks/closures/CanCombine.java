package beeth0ven.tk.qrcoder.exframeworks.closures;

public interface CanCombine<S, T> {
    public S combine(S total, T value);
}
