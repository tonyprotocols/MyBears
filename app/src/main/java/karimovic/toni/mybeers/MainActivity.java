package karimovic.toni.mybeers;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager2.widget.ViewPager2;

import android.content.Intent;
import android.nfc.Tag;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements ButtonExitFFromAboutListener{
    public static final String COUNTRY = "Country: ";
    public static final String SINCE = "Since: ";

    private ViewPager mViewPager;
    private TabLayout mTabLayout;
    private ImageButton mInfoButton;
    private AboutAppFragment mAboutAppFragment;
    private FragmentManager mFragmentManager;
    private NotifyInterface onClickListener;
    private List<Beer> listMyBeers;
    private List<Beer> listAllBeers;

    public Beer getBeer(int position){
        return listAllBeers.get(position);
    }

    public List<Beer> getAllBeers(){
        return listAllBeers;
    }
    public List<Beer> getMyBeers(){
        return listMyBeers;
    }
    public void addToMyBeers(int position){
        listAllBeers.add(listAllBeers.get(position));

        onClickListener.onClick();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setAboutAppButton();

        initViews();
        setUpPager();
        setTabIcons();




        listMyBeers = new ArrayList<Beer>();
        Beer beer1 = null;
        beer1 = new Beer("Ozujsko Pivo", new String(COUNTRY + "Croatia"), "Ozujsko Pivo, a blond beer, is Croatia’s leading brand, dating from 1893. The selection of hops and barley gives Ozujsko a refreshing taste and fine bitter aroma. It should be served at 3°C with compact foam.\n", "5%", SINCE + "1892", R.drawable.ozujskoteaser);
        listMyBeers.add(beer1);

        Beer beer2 = null;
        beer2 = new Beer("Staropramen", new String(COUNTRY + "Czech Republic"), "Staropramen, perfectly balanced for over 150 years, is a traditional Czech Pilsner which is brewed with passion using the finest ingredients including premium Czech hops. It has a fine hoppy, slightly fruity aroma and a refreshing balanced taste.", "5%", SINCE + "1869", R.drawable.staropramen);
        listMyBeers.add(beer2);

        Beer beer3 = null;
        beer3 = new Beer("Heineken", new String(COUNTRY + "Dutch"), "Heineken is a full-bodied premium lager with deep golden color, light fruity aroma, a mild bitter taste and a balanced hop aroma leaving a crisp, clean finish for ultimate refreshing taste. The only beer enjoyed in 192 countries.", "5%", SINCE + "1873", R.drawable.images);
        listMyBeers.add(beer3);

        listAllBeers = new ArrayList<Beer>();
        listAllBeers.add(beer1);
        listAllBeers.add(beer2);
        listAllBeers.add(beer3);
        Beer beer4 = null;
        beer4 = new Beer("Corona Extra", new String(COUNTRY + "Mexico"), "Corona Extra Mexican Lager Beer is an even-keeled imported beer with aromas of fruity-honey and a touch of malt. Brewed in Mexico since 1925, this lager beer's flavor is refreshing, crisp, and well-balanced between hops and malt. Made from the finest-quality blend of filtered water, malted barley, hops, corn, and yeast, this cerveza has a refreshing, smooth taste that offers the perfect balance between heavier European import beer and lighter domestic beer. Corona Extra is a great summer beer, so enjoy it with friends at your next barbecue, beach day, or tailgate. An easy-drinking beer, this Mexican lager contains 149 calories* and 4.6% alcohol by volume. Find Your Beach. *Per 12 fl. oz. serving of average analysis: Calories 149, Carbs 14 grams, Protein 1.1 grams, Fat 0 grams. Relax responsibly®. Corona Extra® Beer. Imported by Crown Imports, Chicago, IL\n" +
                "\n", "4.5%", SINCE + "1998", R.drawable.corona);
        listAllBeers.add(beer4);


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