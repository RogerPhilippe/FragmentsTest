package br.com.philippesis.fragmentstest;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import br.com.philippesis.fragmentstest.fragments.FragmentMain;
import br.com.philippesis.fragmentstest.fragments.FragmentSecondary;

public class MainActivity extends FragmentActivity {

    private ListView lvLayoutLeft;

    private FragmentMain fragmentMain;

    private FragmentSecondary fragmentSecondary;

    private FragmentManager fragmentManager;

    private FragmentTransaction fragmentTransaction;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fragmentManager = getSupportFragmentManager();

        if(savedInstanceState == null) {
            fragmentMain = new FragmentMain();
            fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.add(R.id.idfragLayout, fragmentMain, "fragMain");
            fragmentTransaction.commit();
        }

        lvLayoutLeft = (ListView) findViewById(R.id.idlvLayoutLeft);

        String[] items = new String[] {"Fragment 1", "Fragment 1 - Novo Texto", "Fragment 2"};

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, items);

        lvLayoutLeft.setAdapter(adapter);

        lvLayoutLeft.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                switch (position) {
                    case 0:
                        fragmentMain = new FragmentMain();
                        fragmentTransaction = fragmentManager.beginTransaction();
                        fragmentTransaction.replace(R.id.idfragLayout, fragmentMain, "fragMain");
                        fragmentTransaction.addToBackStack("stack");
                        fragmentTransaction.commit();
                        break;
                    case 1:
                        fragmentMain = (FragmentMain) fragmentManager.findFragmentByTag("fragMain");
                        if(fragmentMain != null) {
                            fragmentMain.setLabelText("Fragment main, texto alterado!");
                        }
                        break;
                    case 2:
                        fragmentSecondary = new FragmentSecondary();
                        fragmentTransaction = fragmentManager.beginTransaction();
                        fragmentTransaction.replace(R.id.idfragLayout, fragmentSecondary, "fragSecondary");
                        fragmentTransaction.addToBackStack("stack");
                        fragmentTransaction.commit();
                        break;
                }
            }
        });

    }
}
