package beeth0ven.tk.qrcoder.storyboards.create;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;

import com.jakewharton.rxbinding2.widget.RxTextView;

import java.util.concurrent.TimeUnit;

import beeth0ven.tk.qrcoder.R;
import beeth0ven.tk.qrcoder.exframeworks.ui.base.BaseFragment;
import beeth0ven.tk.qrcoder.exframeworks.zxing.ExImage;
import butterknife.BindView;
import io.reactivex.android.schedulers.AndroidSchedulers;


public class CreateQRCodeFragment extends BaseFragment {

    private static final String TAG = "CreateQRCodeFragment";

    @BindView(R.id.editText)
    EditText editText;
    @BindView(R.id.imageView)
    ImageView imageView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.create_qrcode_fragment, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
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
