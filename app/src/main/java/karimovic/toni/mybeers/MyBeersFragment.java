package karimovic.toni.mybeers;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MyBeersFragment extends Fragment implements NotifyInterface {
    public static final String COUNTRY = "Country: ";
    public static final String SINCE = "Since: ";


    protected RecyclerView mRecyclerView;

    protected RecyclerAdapterMyBeers mAdapter;
    protected RecyclerView.LayoutManager mLayoutManager;

    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_my_beers, container, false);


        mRecyclerView = (RecyclerView) rootView.findViewById(R.id.recycler_view_my_beers);


        mLayoutManager = new GridLayoutManager(requireActivity(), 2);
        mRecyclerView.setLayoutManager(mLayoutManager);

        MainActivity mainActivity = (MainActivity) getActivity();
        List<Beer> list = mainActivity.getMyBeers();

        mAdapter = new RecyclerAdapterMyBeers(list, requireContext());
        // Set CustomAdapter as the adapter for RecyclerView.
        mRecyclerView.setAdapter(mAdapter);

        // END_INCLUDE(initializeRecyclerView)

        return rootView;
    }

    @Override
    public void onClick() {
        mAdapter.notifyDataSetChanged();
    }


   /* @Override
    public void onCardClick(int position) {

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setMessage("Remove from my beers?")
                .setPositiveButton("Yes", (DialogInterface.OnClickListener) v -> {

                })
                .setTitle(R.string.dialog_title);
        AlertDialog dialog = builder.create();
    }*/
}
