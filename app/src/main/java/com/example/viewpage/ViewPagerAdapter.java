package com.example.viewpage;


import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

public class ViewPagerAdapter extends FragmentStateAdapter {

    private final String[] tabLayouts = {"LINEAR", "GRID", "STAGGERED"};

    public ViewPagerAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        // Tạo Fragment mới với loại LayoutManager tương ứng
        return RecyclerFragment.newInstance(tabLayouts[position]);
    }

    @Override
    public int getItemCount() {
        return tabLayouts.length; // Tổng cộng 3 tab
    }
}