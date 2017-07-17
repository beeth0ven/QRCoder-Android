package beeth0ven.tk.qrcoder.storyboards.main;

import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;
import android.widget.ImageView;
import com.jakewharton.rxbinding2.view.RxView;
import com.jakewharton.rxbinding2.widget.RxTextView;

import java.util.concurrent.TimeUnit;

import beeth0ven.tk.qrcoder.R;
import beeth0ven.tk.qrcoder.exframeworks.ui.base.BaseActivity;
import beeth0ven.tk.qrcoder.internal.exframeworks.zxing.ExImage;
import butterknife.BindView;
import io.reactivex.android.schedulers.AndroidSchedulers;

public class MainActivity extends BaseActivity {

    private static final String TAG = "MainActivity";

    @BindView(R.id.editText)
    EditText editText;
    @BindView(R.id.imageView)
    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setup();
        setupRxUI();
        setupRxAction();
    }

    private void setup() {
    }

    private void setupRxUI() {

        disposables.add(RxTextView.textChanges(editText)
                .map(CharSequence::toString)
                .filter(string -> !string.isEmpty())
                .debounce(1, TimeUnit.SECONDS, AndroidSchedulers.mainThread())
                .map(ExImage::qrcode)
                .subscribe(imageView::setImageBitmap));
    }

    private void setupRxAction() {

    }

}
