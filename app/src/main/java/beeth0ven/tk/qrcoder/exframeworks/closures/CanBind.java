package beeth0ven.tk.qrcoder.exframeworks.closures;

import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;

public interface CanBind<Element> {
    Disposable bind(Observable<Element> element);
}
