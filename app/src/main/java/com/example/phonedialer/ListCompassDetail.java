package com.example.phonedialer;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.CompositePageTransformer;
import androidx.viewpager2.widget.MarginPageTransformer;
import androidx.viewpager2.widget.ViewPager2;

import com.example.phonedialer.adapter.CompassAdapterViewPager;
import com.example.phonedialer.databinding.ActivityListCompassDetailBinding;


public class ListCompassDetail extends AppCompatActivity {
    ActivityListCompassDetailBinding binding;
    CompassAdapterViewPager compassAdapterViewPager;

    ViewPager2 viewPager2;
    public static int selectPosition = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityListCompassDetailBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        viewPager2 = findViewById(R.id.view_pager);
        compassAdapterViewPager = new CompassAdapterViewPager(this,viewPager2);
        viewPager2.setAdapter(compassAdapterViewPager);

        viewPager2.setOffscreenPageLimit(3);
        viewPager2.setClipChildren(false);
        viewPager2.setClipToPadding(false);
        viewPager2.getChildAt(0).setOverScrollMode(RecyclerView.OVER_SCROLL_NEVER);

        CompositePageTransformer transformer = new CompositePageTransformer();
        transformer.addTransformer(new MarginPageTransformer(40));
        transformer.addTransformer(new ViewPager2.PageTransformer() {
            @Override
            public void transformPage(@NonNull View page, float position) {
                float r = 1 - Math.abs(position);
                page.setScaleY(0.85f + r * 0.30f);
                page.setScaleX(0.85f + r * 0.30f);
            }
        });
        viewPager2.setPageTransformer(transformer);
        viewPager2.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
            }
        });
        binding.icBackLeft.setOnClickListener(view -> {
            viewPager2.setCurrentItem(viewPager2.getCurrentItem() - 1);
        });
        binding.icBackRight.setOnClickListener(view -> {
            viewPager2.setCurrentItem(viewPager2.getCurrentItem() + 1);
        });
    }
}