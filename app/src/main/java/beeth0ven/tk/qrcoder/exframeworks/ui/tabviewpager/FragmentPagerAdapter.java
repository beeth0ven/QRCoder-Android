package beeth0ven.tk.qrcoder.exframeworks.ui.tabviewpager;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import java.util.List;
import beeth0ven.tk.qrcoder.exframeworks.foundation.tuples.Tuple;


public class FragmentPagerAdapter extends FragmentStatePagerAdapter {

    private List<Tuple<Fragment, String>> fragmentInfos;

    public FragmentPagerAdapter(FragmentManager fm, List<Tuple<Fragment, String>> fragmentInfos) {
        super(fm);
        this.fragmentInfos = fragmentInfos;
    }

    @Override
    public Fragment getItem(int position) {
        return fragmentInfos.get(position).$0;
    }

    @Override
    public int getCount() {
        return fragmentInfos.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return fragmentInfos.get(position).$1;
    }
}
