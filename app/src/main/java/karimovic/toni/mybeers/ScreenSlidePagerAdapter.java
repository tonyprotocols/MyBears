package karimovic.toni.mybeers;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import java.util.Locale;

public class ScreenSlidePagerAdapter extends FragmentStatePagerAdapter {
    private static final int NUM_PAGES = 2;


    public ScreenSlidePagerAdapter(FragmentManager fm){
        super(fm);
    }


    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                return ScreenSlidePageFragment.newInstance("This is fragment #1");
            case 1:
                return ScreenSlidePageFragment.newInstance("This is fragment #2");
            default:
                return ScreenSlidePageFragment.newInstance("This is fragment #3");
        }
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position){
        return null;
    }


    @Override
    public int getCount() {
        return NUM_PAGES;
    }
}
