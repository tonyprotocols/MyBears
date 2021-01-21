package karimovic.toni.mybeers;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

import java.util.function.ToDoubleBiFunction;


public class AboutAppFragment extends Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view;
        ImageButton mExitButton;
        view = inflater.inflate(R.layout.fragment_about_app, container, false);
        mExitButton = (ImageButton) view.findViewById(R.id.btnInfoExit);

        mExitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "About Fragment Exit", Toast.LENGTH_LONG).show();
            }
        });
        return view;
    }


}