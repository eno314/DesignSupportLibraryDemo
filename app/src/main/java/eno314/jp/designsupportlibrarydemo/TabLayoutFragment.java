package eno314.jp.designsupportlibrarydemo;

import android.app.Fragment;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by eno314 on 2015/06/02.
 */
public class TabLayoutFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_tab_layout, container, false);

        final TextView textView = (TextView) view.findViewById(R.id.tab_layout_text);

        final TabLayout tabLayout = (TabLayout) view.findViewById(R.id.tab_layout);
        tabLayout.addTab(tabLayout.newTab().setText("Tab 1"));
        tabLayout.addTab(tabLayout.newTab().setText("Tab 2"));
        tabLayout.addTab(tabLayout.newTab().setText("Tab 3"));
        tabLayout.addTab(tabLayout.newTab().setText("Tab 4"));
        tabLayout.addTab(tabLayout.newTab().setText("Tab 5"));
        tabLayout.addTab(tabLayout.newTab().setText("Tab 6"));
        tabLayout.addTab(tabLayout.newTab().setText("Tab 7"));
        tabLayout.addTab(tabLayout.newTab().setText("Tab 8"));
        tabLayout.addTab(tabLayout.newTab().setText("Tab 9"));

        textView.setText(tabLayout.getTabAt(0).getText());

        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                // タブをタップした時に呼ばれる
                textView.setText(tab.getText());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
                // 選択中だったタブが別のタブに切り替わった時呼ばれる
                // 引数で渡されるのは選択中だったタブ
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {
                // 選択されているタブをタップした時に呼ばれる
            }
        });

        return view;
    }

    public static TabLayoutFragment newInstance() {
        final TabLayoutFragment fragment = new TabLayoutFragment();

        return fragment;
    }
}
