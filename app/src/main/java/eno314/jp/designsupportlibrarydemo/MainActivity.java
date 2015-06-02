package eno314.jp.designsupportlibrarydemo;

import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;


public class MainActivity extends AppCompatActivity {

    private DrawerLayout mDrawer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mDrawer = (DrawerLayout) findViewById(R.id.main_drawer);

        final NavigationView navigationView = (NavigationView) findViewById(R.id.main_navigation);

        // ナビゲーションメニューのクリックリスナー登録
        navigationView.setNavigationItemSelectedListener(getNavigationItemSelectedListener());

        findViewById(R.id.floating_action_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mDrawer.isDrawerOpen(GravityCompat.START)) {
                    mDrawer.closeDrawer(GravityCompat.START);
                } else {
                    mDrawer.openDrawer(GravityCompat.START);
                }
            }
        });

        if (savedInstanceState == null) {
            getFragmentManager().beginTransaction()
                    .replace(R.id.main_content, TextInputLayoutFragment.newInstance())
                    .commit();
        }
    }

    private NavigationView.OnNavigationItemSelectedListener getNavigationItemSelectedListener() {
        return new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem menuItem) {
                if (menuItem.isChecked()) {
                    return false;
                }

                final int itemId = menuItem.getItemId();

                if (itemId == R.id.group_navigation_item_1) {
                    onSelectGroupNavigation(menuItem);
                    getFragmentManager().beginTransaction()
                            .replace(R.id.main_content, TextInputLayoutFragment.newInstance())
                            .commit();
                    return true;
                }

                if (itemId == R.id.group_navigation_item_2) {
                    onSelectGroupNavigation(menuItem);
                    getFragmentManager().beginTransaction()
                            .replace(R.id.main_content, TabLayoutFragment.newInstance())
                            .commit();
                    return true;
                }

                if (itemId == R.id.navigation_subitem_show_snackbar) {
                    Snackbar.make(mDrawer, "message", Snackbar.LENGTH_LONG)
                            .setAction("OK", new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    Log.d("AAAAA", "click snackbar action");
                                }
                            })
                            .show();
                    return true;
                }

                return false;
            }
        };
    }

    private void onSelectGroupNavigation(MenuItem menuItem) {
        menuItem.setChecked(true);
        mDrawer.closeDrawer(GravityCompat.START);
    }
}
