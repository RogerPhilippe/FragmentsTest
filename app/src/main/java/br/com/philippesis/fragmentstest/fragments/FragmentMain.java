package br.com.philippesis.fragmentstest.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import br.com.philippesis.fragmentstest.R;

public class FragmentMain extends Fragment {

    private TextView tvFragMain;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState){

        View view = inflater.inflate(R.layout.fragment_main, null);

        tvFragMain = (TextView) view.findViewById(R.id.idtvFragMain);

        return view;
    }

    public void setLabelText(String text) {
        tvFragMain.setText(text);
    }

}
