package karimovic.toni.mybeers;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;


public class ScreenSlidePagerAdapter extends FragmentStatePagerAdapter {
    private static final int NUM_PAGES = 2;


    public ScreenSlidePagerAdapter(FragmentManager fm){
        super(fm, FragmentStatePagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
    }


    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                return new MyBeersFragment();
            case 1:
                return new AllBeersFragment();
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
