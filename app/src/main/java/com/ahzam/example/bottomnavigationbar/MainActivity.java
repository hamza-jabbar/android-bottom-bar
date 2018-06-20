package com.ahzam.example.bottomnavigationbar;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.FrameLayout;

public class MainActivity extends AppCompatActivity {

    private BottomNavigationView mMainNav;
    private FrameLayout mMainFrame;

    private HomeFragment homeFragment;
    private NotificationFragment notificationFragment;
    private AccountFragment accountFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        homeFragment = new HomeFragment();
        notificationFragment = new NotificationFragment();
        accountFragment = new AccountFragment();

        mMainFrame = findViewById(R.id.main_frame);
        mMainNav = findViewById(R.id.main_bottomNav);

        //  Set default fragment to the 'HomeFragment' i.e the first page the user sees
        setFragment(homeFragment);

        mMainNav.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch(item.getItemId()) {
                    case R.id.menu_home:
                        //  Sets the background color of the bottomnavigationview
                        mMainNav.setItemBackgroundResource(R.color.colorPrimaryDark);
                        setFragment(homeFragment);
                        return true;

                    case R.id.menu_notification:
                        //  Sets the background color of the bottomnavigationview
                        mMainNav.setItemBackgroundResource(R.color.colorPrimaryDark);
                        setFragment(notificationFragment);
                        return true;

                    case R.id.menu_account:
                        //  Sets the background color of the bottomnavigationview
                        mMainNav.setItemBackgroundResource(R.color.colorPrimaryDark);
                        setFragment(accountFragment);
                        return true;

                    default:
                        return false;
                }
            }
        });
    }

    private void setFragment(Fragment fragment) {
        //  Allows for changing fragments
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        //  Put it in the layout and specify which fragment is going to go in that layout
        fragmentTransaction.replace(R.id.main_frame, fragment);
        //  The fragment is "committed" to the actions above
        fragmentTransaction.commit();
    }
}
