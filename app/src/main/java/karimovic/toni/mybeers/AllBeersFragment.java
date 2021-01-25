package karimovic.toni.mybeers;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class AllBeersFragment extends Fragment implements OnCardClickListener {
    public static final String COUNTRY = "Country: ";
    public static final String SINCE = "Since: ";

    protected RecyclerView mRecyclerView;

    protected RecyclerAdapterAllBeers mAdapter;
    protected RecyclerView.LayoutManager mLayoutManager;

    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_all_beers_list, container, false);


        mRecyclerView = (RecyclerView) rootView.findViewById(R.id.recycler_view_all_beers);


        mLayoutManager = new GridLayoutManager(requireActivity(), 2);
        mRecyclerView.setLayoutManager(mLayoutManager);

        List<Beer> list = new ArrayList<Beer>();
        Beer beer1 = null;
        beer1 = new Beer("Ozujsko", new String(COUNTRY + "Croatia"), "aaa", "5%", SINCE + "1892", R.drawable.ozujskoteaser);
        list.add(beer1);

        Beer beer2 = null;
        beer2 = new Beer("Staropramen", new String(COUNTRY + "Czech Republic"), "aaa", "5%", SINCE + "1869", R.drawable.staropramen);
        list.add(beer2);

        Beer beer3 = null;
        beer3 = new Beer("Heineken", new String(COUNTRY + "Dutch"), "aaa", "5%", SINCE + "1873", R.drawable.images);
        list.add(beer3);
        Beer beer4 = null;
        beer4 = new Beer("Corona", new String(COUNTRY + "Mexico"), "aaa", "4.5%", SINCE + "1998", R.drawable.corona);
        list.add(beer4);


        mAdapter = new RecyclerAdapterAllBeers(null, list);
        mRecyclerView.setAdapter(mAdapter);
        

        return rootView;
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {

    }

    @Override
    public void onCardClick(int position) {
        Log.d("Card View:", "position" + position);
    }
}
