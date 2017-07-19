package beeth0ven.tk.qrcoder.exframeworks.ui.tabviewpager;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;

import java.util.List;

import beeth0ven.tk.qrcoder.exframeworks.foundation.tuples.Tuple;

public class TabViewPagerPresenter {

    public static void setup(FragmentManager manager, TabLayout tabLayout, ViewPager viewPager, List<Tuple<Fragment, String>> infos) {
        viewPager.setOffscreenPageLimit(infos.size());
        viewPager.setAdapter(new FragmentPagerAdapter(manager, infos));
        tabLayout.setupWithViewPager(viewPager);
    }
}
