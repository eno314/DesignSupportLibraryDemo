package eno314.jp.designsupportlibrarydemo;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by eno314 on 2015/05/31.
 */
public class TextInputLayoutFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_text_input_layout, container, false);

        return view;
    }

    public static TextInputLayoutFragment newInstance() {
        final TextInputLayoutFragment fragment = new TextInputLayoutFragment();

        return fragment;
    }
}
