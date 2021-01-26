package karimovic.toni.mybeers;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

public class BeerInfoFragment  extends Fragment {
    private ButtonExitFFromAboutListener mButtonListener;
    private NotifyInterface notifyInterface;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view;
        ImageButton mExitButton;
        ImageButton mAddToMyBeers;

        view = inflater.inflate(R.layout.fragment_about_beers, container, false);


        TextView textViewDescription = view.findViewById(R.id.tvAboutBeerText);
        TextView textViewName = view.findViewById(R.id.aboutTitle);
        mExitButton = (ImageButton) view.findViewById(R.id.aboutExit);
        mAddToMyBeers = (ImageButton) view.findViewById(R.id.btn_add_to_my_beers);

        Bundle arguments = getArguments();
        int position = arguments.getInt("position");
        MainActivity mainActivity = (MainActivity) getActivity();
        Beer beer = mainActivity.getBeer(position);
        textViewDescription.setText(beer.getDescription());
        textViewName.setText(beer.getName());

        mExitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mButtonListener != null)
                    mButtonListener.onButtonCLicked(true);
            }
        });

        mAddToMyBeers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(notifyInterface != null){
                    mainActivity.addToMyBeers(position);
                    notifyInterface.onClick();
                }
            }
        });
        return view;
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        if (context instanceof ButtonExitFFromAboutListener) {
            mButtonListener = (ButtonExitFFromAboutListener) context;
        }
        if (context instanceof NotifyInterface) {
            notifyInterface = (NotifyInterface) context;
        }
    }
}