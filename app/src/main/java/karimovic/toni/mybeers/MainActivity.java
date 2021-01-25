package karimovic.toni.mybeers;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager2.widget.ViewPager2;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity implements ButtonExitFFromAboutListener{

    private ViewPager mViewPager;
    private TabLayout mTabLayout;
    private ImageButton mInfoButton;
    private AboutAppFragment mAboutAppFragment;
    private FragmentManager mFragmentManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setAboutAppButton();

        initViews();
        setUpPager();
        setTabIcons();


    }

    private void setAboutAppButton() {
        AboutAppFragment aboutAppFragment = new AboutAppFragment();
        mInfoButton = (ImageButton) findViewById(R.id.btAboutApp);
        mInfoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
                fragmentTransaction.add(R.id.flAboutAppFragmentContainer, aboutAppFragment);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
            }
        });
    }

    private void setUpAboutAppFragment() {


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

    @Override
    public void onButtonCLicked(boolean state) {
        onBackPressed();
    }


}