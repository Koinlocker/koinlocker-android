package com.wallet.koinlocker;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.wallet.koinlocker.fragments.AccountFragment;
import com.wallet.koinlocker.fragments.SendAndReceiveFragment;
import com.wallet.koinlocker.fragments.SettingsFragment;
import com.wallet.koinlocker.listeners.OnSwipeTouchListener;

import java.util.List;

public class HomeActivity extends AppCompatActivity {

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {

            Fragment fragment;

            switch (item.getItemId()) {

                case R.id.navigation_settings:
                    fragment = new SettingsFragment();
                    loadFragment(fragment);
                    break;
                case R.id.navigation_account:
                    fragment = new AccountFragment();
                    loadFragment(fragment);
                    break;
                case R.id.navigation_send_receive:
                    fragment = new SendAndReceiveFragment();
                    loadFragment(fragment);
                    break;
            }
            return true;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setLogo(R.mipmap.kl_logo);
        getSupportActionBar().setDisplayUseLogoEnabled(true);

        loadFragment(new AccountFragment());

        final BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        navigation.setSelectedItemId(R.id.navigation_account);

        final FrameLayout frameLayout = findViewById(R.id.bottomViewContainer);
        frameLayout.setOnTouchListener(new OnSwipeTouchListener(HomeActivity.this) {

            public void onSwipeRight() {
                if (getVisibleFragment() instanceof SendAndReceiveFragment) {
                    loadFragment(new AccountFragment());
                    navigation.setSelectedItemId(R.id.navigation_account);
                } else if (getVisibleFragment() instanceof AccountFragment) {
                    loadFragment(new SettingsFragment());
                    navigation.setSelectedItemId(R.id.navigation_settings);
                }
            }

            public void onSwipeLeft() {
                if (getVisibleFragment() instanceof SettingsFragment) {
                    loadFragment(new AccountFragment());
                    navigation.setSelectedItemId(R.id.navigation_account);
                } else if (getVisibleFragment() instanceof AccountFragment) {
                    loadFragment(new SendAndReceiveFragment());
                    navigation.setSelectedItemId(R.id.navigation_send_receive);
                }
            }
        });
    }

    private void loadFragment(Fragment fragment) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.bottomViewContainer, fragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }

    public Fragment getVisibleFragment() {
        FragmentManager fragmentManager = HomeActivity.this.getSupportFragmentManager();
        List<Fragment> fragments = fragmentManager.getFragments();
        if (fragments != null) {
            for (Fragment fragment : fragments) {
                if (fragment != null && fragment.isVisible())
                    return fragment;
            }
        }
        return null;
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        moveTaskToBack(true);
        android.os.Process.killProcess(android.os.Process.myPid());
        System.exit(1);
    }
}
