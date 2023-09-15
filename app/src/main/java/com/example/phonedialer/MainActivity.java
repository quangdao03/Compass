package com.example.phonedialer;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.LayoutInflater;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.core.view.WindowInsetsControllerCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;


import com.example.phonedialer.Fragment.FragmentHome;
import com.example.phonedialer.Fragment.FragmentOptions;
import com.example.phonedialer.Fragment.FragmentSetting;
import com.example.phonedialer.Fragment.FragmentWeather;
import com.example.phonedialer.databinding.ActivityCompassBinding;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class MainActivity extends AppCompatActivity {
    ActivityCompassBinding binding;
    public static int position;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityCompassBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        hideNavigation();
        addTabs(binding.vpApp);
        binding.vpApp.setCurrentItem(position);
        binding.vpApp.setOffscreenPageLimit(4);
        binding.vpApp.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            public void onPageScrollStateChanged(int i) {
                Log.e("ss", "");
            }

            public void onPageScrolled(int i, float f, int i2) {
                Log.e("ss", "");
            }

            public void onPageSelected(int i) {
                MainActivity.this.setposition(i);
            }
        });
        binding.clTheme.setOnClickListener(view -> {
            binding.vpApp.setCurrentItem(0);
            setposition(0);

        });
        binding.clPhoto.setOnClickListener(view -> {
            setposition(1);
            binding.vpApp.setCurrentItem(1);

        });
        binding.clFont.setOnClickListener(view -> {
            setposition(2);
            binding.vpApp.setCurrentItem(2);

        });
        binding.clSetting.setOnClickListener(view -> {
            setposition(3);
            binding.vpApp.setCurrentItem(3);

        });
    }
    private void addTabs(ViewPager viewPager) {
        ViewPagerAdapter viewPagerAdapterr = new ViewPagerAdapter(getSupportFragmentManager());
        viewPagerAdapterr.addFrag(new FragmentHome(), "fragment_home");
        viewPagerAdapterr.addFrag(new FragmentOptions(), "fragment_options");
        viewPagerAdapterr.addFrag(new FragmentWeather(), "fragment_weather");
        viewPagerAdapterr.addFrag(new FragmentSetting(), "fragment_setting");
        viewPager.setAdapter(viewPagerAdapterr);
    }

    public static class ViewPagerAdapter extends FragmentPagerAdapter {

        private final List<Fragment> mFragmentList = new ArrayList<>();
        private final List<String> mFragmentTitleList = new ArrayList<>();

        public ViewPagerAdapter(@NonNull FragmentManager fm) {
            super(fm);
        }

        @NonNull
        @Override
        public Fragment getItem(int position) {
            return this.mFragmentList.get(position);
        }

        @Override
        public int getCount() {
            return this.mFragmentList.size();
        }

        public void addFrag(Fragment fragment, String str) {
            this.mFragmentList.add(fragment);
            this.mFragmentTitleList.add(str);
        }

        @Override
        public CharSequence getPageTitle(int i) {
            return this.mFragmentTitleList.get(i);
        }
    }
    @SuppressLint({"UseCompatLoadingForColorStateLists", "UseCompatLoadingForDrawables"})
    public void setposition(int i) {
        if (i == 0) {
            getDefaultSelect();
            binding.tvTheme.setTextColor(Color.parseColor("#FFFFFF"));
            binding.imgTheme.setImageResource(R.drawable.ic_home_select);

        } else if (i == 1) {
            getDefaultSelect();
            binding.tvPhoto.setTextColor(Color.parseColor("#FFFFFF"));
            binding.imgPhoto.setImageResource(R.drawable.ic_option_select);


        } else if (i == 2) {
            getDefaultSelect();
            binding.tvFont.setTextColor(Color.parseColor("#FFFFFF"));
            binding.imgFont.setImageResource(R.drawable.ic_weather_select);

        } else {
            getDefaultSelect();
            binding.tvSetting.setTextColor(Color.parseColor("#FFFFFF"));
            binding.imgSetting.setImageResource(R.drawable.ic_setting_selects);

        }
    }
    private void getDefaultSelect() {
        binding.imgTheme.setImageResource(R.drawable.ic_home);
        binding.imgPhoto.setImageResource(R.drawable.ic_option);
        binding.imgFont.setImageResource(R.drawable.ic_weather);
        binding.imgSetting.setImageResource(R.drawable.ic_setting);
        binding.tvTheme.setTextColor(Color.parseColor("#616F7C"));
        binding.tvPhoto.setTextColor(Color.parseColor("#616F7C"));
        binding.tvFont.setTextColor(Color.parseColor("#616F7C"));
        binding.tvSetting.setTextColor(Color.parseColor("#616F7C"));
    }
    private void hideNavigation() {
        WindowInsetsControllerCompat windowInsetsController;
        if (Build.VERSION.SDK_INT >= 30) {
            windowInsetsController = ViewCompat.getWindowInsetsController(getWindow().getDecorView());
        } else
            windowInsetsController = new WindowInsetsControllerCompat(getWindow(), LayoutInflater.from(this).inflate(R.layout.activity_compass, null));

        if (windowInsetsController == null) {
            return;
        }
        windowInsetsController.setSystemBarsBehavior(
                WindowInsetsControllerCompat.BEHAVIOR_SHOW_BARS_BY_SWIPE
        );
        windowInsetsController.hide(WindowInsetsCompat.Type.navigationBars());

        getWindow().getDecorView().setOnSystemUiVisibilityChangeListener(i -> {
            if (i == 0) {
                new Handler().postDelayed(() -> {
                    WindowInsetsControllerCompat windowInsetsController1;
                    if (Build.VERSION.SDK_INT >= 30) {
                        windowInsetsController1 = ViewCompat.getWindowInsetsController(getWindow().getDecorView());
                    } else {
                        windowInsetsController1 = new WindowInsetsControllerCompat(getWindow(), LayoutInflater.from(this).inflate(R.layout.activity_compass, null));
                    }
                    Objects.requireNonNull(windowInsetsController1).hide(WindowInsetsCompat.Type.navigationBars());
                }, 3000);
            }
        });
    }
}