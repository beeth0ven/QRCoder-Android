package beeth0ven.tk.qrcoder.exframeworks.rx;

import android.util.Log;

import beeth0ven.tk.qrcoder.exframeworks.foundation.tuples.Void;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.ObservableTransformer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;

public class Rx {

    public static <T, R> ObservableTransformer<T, R> flatMapLatest(Function<? super T, ? extends ObservableSource<? extends R>> mapper) {
        return observable -> Observable.switchOnNext(observable.map(mapper));
    }

    public static <T> ObservableTransformer<T, T> shareReplay(int bufferSize) {
        return observable -> observable.replay(bufferSize).refCount();
    }

    public static <T> ObservableTransformer<T, Void> mapToVoid() {
        return observable -> observable.map(ignore -> Void.create());
    }

    public static <T> ObservableTransformer<T, T> io2Main() {
        return observable -> observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }

    public static <T> ObservableTransformer<T, T> debug(String TAG) {
        return observable -> observable
                .doOnSubscribe(disposable -> Log.d(TAG, "onSubscribe"))
                .doOnNext(value -> Log.d(TAG, "onNext: " + value))
                .doOnError(error -> Log.d(TAG, "onError: " + error.getMessage()))
                .doOnComplete(() -> Log.d(TAG, "onComplete"))
                .doOnDispose(() -> Log.d(TAG, "onDispose"));
    }
}
