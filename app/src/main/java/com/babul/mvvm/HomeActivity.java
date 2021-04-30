package com.babul.mvvm;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.babul.mvvm.adapters.FragmentAdapter;
import com.babul.mvvm.views.DemoFragment;
import com.babul.mvvm.views.Homefragment;
import com.google.android.material.tabs.TabLayout;
import java.util.Objects;

public class HomeActivity extends AppCompatActivity {

    ViewPager viewPager;
    TabLayout tabLayout;
    @Override
    protected void onCreate (Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewPager = findViewById(R.id.viewpager);
        setupViewPager(viewPager);

        tabLayout = (TabLayout) findViewById(R.id.tabLayout);
        tabLayout.setupWithViewPager(viewPager);
        setupTabIcons();

    }

    private void setupTabIcons() {
        Objects.requireNonNull(tabLayout.getTabAt(0)).setIcon(R.drawable.home);
        Objects.requireNonNull(tabLayout.getTabAt(1)).setIcon(R.drawable.orders);
        Objects.requireNonNull(tabLayout.getTabAt(2)).setIcon(R.drawable.notification);
        Objects.requireNonNull(tabLayout.getTabAt(3)).setIcon(R.drawable.account);
    }

    private void setupViewPager(ViewPager viewPager) {
        FragmentAdapter adapter = new FragmentAdapter(getSupportFragmentManager());
        adapter.addFrag(new Homefragment(), getString(R.string.home));
        adapter.addFrag(new DemoFragment(), getString(R.string.orders));
        adapter.addFrag(new DemoFragment(), getString(R.string.notifications));
        adapter.addFrag(new DemoFragment(), getString(R.string.account));
        viewPager.setAdapter(adapter);
    }
}