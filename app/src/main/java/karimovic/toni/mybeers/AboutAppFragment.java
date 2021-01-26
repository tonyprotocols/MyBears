package karimovic.toni.mybeers;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;


public class AboutAppFragment extends Fragment {

    private ButtonExitFFromAboutListener mButtonListener;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view;
        ImageButton mExitButton;
        view = inflater.inflate(R.layout.fragment_about_app, container, false);
        mExitButton = (ImageButton) view.findViewById(R.id.btnInfoExit);

        mExitButton.setOnClickListener(v -> {
            if (mButtonListener != null)
                mButtonListener.onButtonCLicked(true);
        });
        return view;
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        if(context instanceof ButtonExitFFromAboutListener){
            mButtonListener = (ButtonExitFFromAboutListener) context;

        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mButtonListener = null;
    }
}