package beeth0ven.tk.qrcoder.storyboards.scan;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import beeth0ven.tk.qrcoder.R;
import beeth0ven.tk.qrcoder.exframeworks.ui.base.BaseFragment;

public class ScanQRCodeFragment extends BaseFragment {

    private static final String TAG = "ScanQRCodeFragment";

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.scan_qrcode_fragment, container, false);
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
    }

    private void setupRxAction() {

    }

}
