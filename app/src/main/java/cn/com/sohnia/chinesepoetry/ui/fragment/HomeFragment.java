package cn.com.sohnia.chinesepoetry.ui.fragment;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import cn.com.sohnia.chinesepoetry.R;
import cn.com.sohnia.chinesepoetry.adapter.MainViewPagerAdapter;

public class HomeFragment extends Fragment{

    @BindView(R.id.tablayout)
    TabLayout tabLayout;
    @BindView(R.id.fragment_home_viewpager)
    ViewPager viewPager;
    private MainViewPagerAdapter mainViewPagerAdapter;
    private ArrayList<Fragment> fragments;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_home,container,false);
        ButterKnife.bind(this,rootView);
        initFragments();
        mainViewPagerAdapter = new MainViewPagerAdapter(getChildFragmentManager(),fragments);
        viewPager.setAdapter(mainViewPagerAdapter);
//        viewPager.addOnPageChangeListener(this);
        tabLayout.setupWithViewPager(viewPager);
        initTabLayout();
        return rootView;
    }

    private void initFragments() {
        fragments=new ArrayList<>();
        HomeCommedFragment homeCommedFragment = new HomeCommedFragment();
        HomePoetryFragment homePoetryFragment = new HomePoetryFragment();
        HomeSentenceFragment homeSentenceFragment = new HomeSentenceFragment();
        fragments.add(homeCommedFragment);
        fragments.add(homePoetryFragment);
        fragments.add(homeSentenceFragment);
    }
    private void initTabLayout() {
        String [] tmp = getResources().getStringArray(R.array.home_item);
        for(int i = 0; i < 3 ; i++){
            tabLayout.getTabAt(i).setText(tmp[i]);
        }
    }
}
