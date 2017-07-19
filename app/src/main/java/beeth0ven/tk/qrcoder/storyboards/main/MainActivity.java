package beeth0ven.tk.qrcoder.storyboards.main;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;

import beeth0ven.tk.qrcoder.R;
import beeth0ven.tk.qrcoder.exframeworks.foundation.Stream;
import beeth0ven.tk.qrcoder.exframeworks.foundation.tuples.Tuple;
import beeth0ven.tk.qrcoder.exframeworks.ui.base.BaseActivity;
import beeth0ven.tk.qrcoder.exframeworks.ui.tabviewpager.TabViewPagerPresenter;
import beeth0ven.tk.qrcoder.storyboards.create.CreateQRCodeFragment;
import beeth0ven.tk.qrcoder.storyboards.scan.ScanQRCodeFragment;
import butterknife.BindView;

public class MainActivity extends BaseActivity {

    private static final String TAG = "MainActivity";

    @BindView(R.id.tabLayout)
    TabLayout tabLayout;
    @BindView(R.id.viewPager)
    ViewPager viewPager;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setup();
        setupRxUI();
        setupRxAction();
    }


    private void setup() {

        TabViewPagerPresenter.setup(getSupportFragmentManager(), tabLayout, viewPager, Stream.asList(
                Tuple.create(new ScanQRCodeFragment(), "Scan"),
                Tuple.create(new CreateQRCodeFragment(), "Create")
        ));

    }

    private void setupRxUI() {
        setTitle("Scan");
    }

    private void setupRxAction() {

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                setTitle(tab.getText());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

    }

}
