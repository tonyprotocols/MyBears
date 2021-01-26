package karimovic.toni.mybeers;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class AllBeersFragment extends Fragment implements OnCardClickListener {


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

        MainActivity mainActivity = (MainActivity) getActivity();
        List<Beer> list = mainActivity.getAllBeers();

        mAdapter = new RecyclerAdapterAllBeers(this, list);
        mRecyclerView.setAdapter(mAdapter);
        

        return rootView;
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {

    }

    @Override
    public void onCardClick(int position) {
        Bundle arguments = new Bundle();
        arguments.putInt("position" , position);
        BeerInfoFragment beerInfoFragment = new BeerInfoFragment();
        beerInfoFragment.setArguments(arguments);
        FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
        fragmentTransaction.add(R.id.about_beer_frame_layout, beerInfoFragment);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }
}
