package beeth0ven.tk.qrcoder.exframeworks.ui.base;

import android.support.annotation.LayoutRes;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;

import beeth0ven.tk.qrcoder.exframeworks.foundation.tuples.Void;
import butterknife.ButterKnife;
import io.reactivex.Observable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.subjects.PublishSubject;

public class BaseActivity extends AppCompatActivity {

    protected final CompositeDisposable disposables = new CompositeDisposable();
    private final PublishSubject<Void> _rxDestroy = PublishSubject.create();
    protected final Observable<Void> rxDestroy = _rxDestroy;


    @Override
    public void setContentView(@LayoutRes int layoutResID) {
        super.setContentView(layoutResID);
        ButterKnife.bind(this);
    }

    @Override
    public void setContentView(View view) {
        super.setContentView(view);
        ButterKnife.bind(this);
    }

    @Override
    public void setContentView(View view, ViewGroup.LayoutParams params) {
        super.setContentView(view, params);
        ButterKnife.bind(this);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        disposables.dispose();
        _rxDestroy.onNext(Void.create());
    }
}
