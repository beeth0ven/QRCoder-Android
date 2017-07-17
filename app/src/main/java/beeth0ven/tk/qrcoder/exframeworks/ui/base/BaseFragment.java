package beeth0ven.tk.qrcoder.exframeworks.ui.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.View;

import beeth0ven.tk.qrcoder.exframeworks.foundation.tuples.Void;
import butterknife.ButterKnife;
import io.reactivex.Observable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.subjects.PublishSubject;


public class BaseFragment extends Fragment {

    protected final CompositeDisposable disposables = new CompositeDisposable();
    private final PublishSubject<Void> _rxDestroy = PublishSubject.create();
    protected final Observable<Void> rxDestroy = _rxDestroy;

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ButterKnife.bind(this, view);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        disposables.dispose();
        _rxDestroy.onNext(Void.create());
    }
}
