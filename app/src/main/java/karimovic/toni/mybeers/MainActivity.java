package karimovic.toni.mybeers;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {

    private ViewPager mViewPager;
    private TabLayout mTabLayout;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
        setUpPager();
        setTabIcons();
    }

    private void setTabIcons() {
        ImageView imgViewMyBears= new ImageView(MainActivity.this);
        imgViewMyBears.setImageResource(R.drawable.ic_my_beers);
        imgViewMyBears.setPadding(10,10,10,10);
        mTabLayout.getTabAt(0).setCustomView(imgViewMyBears);

        ImageView imgViewBeerList= new ImageView(MainActivity.this);
        imgViewBeerList.setImageResource(R.drawable.ic_beer_list);
        imgViewBeerList.setPadding(10,10,10,10);
        mTabLayout.getTabAt(1).setCustomView(imgViewBeerList);
    }

    private void setUpPager() {
        PagerAdapter pagerAdapter = new ScreenSlidePagerAdapter(getSupportFragmentManager());
        mViewPager.setAdapter(pagerAdapter);
        mTabLayout.setupWithViewPager(mViewPager);
    }

    private void initViews() {
        mViewPager = findViewById(R.id.viewPager);
        mTabLayout = findViewById(R.id.tab);
    }

}