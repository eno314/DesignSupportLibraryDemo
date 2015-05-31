package eno314.jp.designsupportlibrarydemo;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MenuItem;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final NavigationView navigationView = (NavigationView) findViewById(R.id.main_navigation);

        // ナビゲーションメニューのクリックリスナー登録
        navigationView.setNavigationItemSelectedListener(getNavigationItemSelectedListener());
    }
    
    private NavigationView.OnNavigationItemSelectedListener getNavigationItemSelectedListener() {
        return new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem menuItem) {
                menuItem.setChecked(true);

                final int itemId = menuItem.getItemId();

                if (itemId == R.id.group_navigation_item_1) {
                    Log.d("AAAAA", "group_navigation_item_1");
                    return true;
                }

                if (itemId == R.id.group_navigation_item_2) {
                    Log.d("AAAAA", "group_navigation_item_2");
                    return true;
                }

                return false;
            }
        };
    }
}
