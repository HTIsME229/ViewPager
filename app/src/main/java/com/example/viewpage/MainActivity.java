package com.example.viewpage;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

public class MainActivity extends AppCompatActivity {

    private String[] tabTitles = {"Tab 1: Danh sách", "Tab 2: Lưới (Grid)", "Tab 3: Xếp lớp (Staggered)"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TabLayout tabLayout = findViewById(R.id.tab_layout);
        ViewPager2 viewPager = findViewById(R.id.view_pager);

        // 1. Thiết lập Adapter cho ViewPager2
        ViewPagerAdapter adapter = new ViewPagerAdapter(this);
        viewPager.setAdapter(adapter);

        // 2. Liên kết TabLayout với ViewPager2
        new TabLayoutMediator(tabLayout, viewPager,
                (tab, position) -> tab.setText(tabTitles[position])
        ).attach();
    }
}