package cn.com.sohnia.chinesepoetry.ui.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.RadioButton;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import cn.com.sohnia.chinesepoetry.R;
import cn.com.sohnia.chinesepoetry.adapter.MainViewPagerAdapter;
import cn.com.sohnia.chinesepoetry.ui.base.BaseActivity;
import cn.com.sohnia.chinesepoetry.ui.fragment.AuthorFragment;
import cn.com.sohnia.chinesepoetry.ui.fragment.HomeFragment;
import cn.com.sohnia.chinesepoetry.ui.fragment.MineFragment;
import cn.com.sohnia.chinesepoetry.ui.fragment.PhotoFragment;
import cn.com.sohnia.chinesepoetry.ui.presenter.MainActivityPresenter;
import cn.com.sohnia.chinesepoetry.ui.view.IMainActivity;
import skin.support.widget.SkinCompatSupportable;

public class MainActivity extends BaseActivity<IMainActivity,MainActivityPresenter>
        implements IMainActivity,SkinCompatSupportable, ViewPager.OnPageChangeListener {

    @BindView(R.id.viewPager)
    ViewPager viewPager;
    @BindView(R.id.radio_home)
    RadioButton radioHome;
    @BindView(R.id.radio_author)
    RadioButton radioAuthor;
    @BindView(R.id.radio_photo)
    RadioButton radioPhoto;
    @BindView(R.id.radio_mine)
    RadioButton radioMine;

    private long mFirstClickTime;
    private ArrayList<Fragment> fragments;
    private Unbinder unbinder;
    private MainViewPagerAdapter mainViewPagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        unbinder = ButterKnife.bind(this);
        initFragment();
        mainViewPagerAdapter = new MainViewPagerAdapter(getSupportFragmentManager(),fragments);
        viewPager.setAdapter(mainViewPagerAdapter);
        viewPager.addOnPageChangeListener(this);
        mPresenter.getStoragePremission();
    }

    private void initFragment() {
        fragments=new ArrayList<>();
        HomeFragment homeFragment = new HomeFragment();
        AuthorFragment authorFragment = new AuthorFragment();
        PhotoFragment photoFragment = new PhotoFragment();
        MineFragment mineFragment = new MineFragment();
        fragments.add(homeFragment);
        fragments.add(authorFragment);
        fragments.add(photoFragment);
        fragments.add(mineFragment);
    }

    @Override
    protected MainActivityPresenter createPresenter() {
        return new MainActivityPresenter(this);
    }

    @Override
    public void applySkin() {

    }

    @Override
    public void onPageScrolled(int i, float v, int i1) {
    }

    @Override
    public void onPageSelected(int position) {
        resetCheckedState();
        switch (position){
            case 0:
                radioHome.setChecked(true);
                break;
            case 1:
                radioAuthor.setChecked(true);
                break;
            case 2:
                radioPhoto.setChecked(true);
                break;
            case 3:
                radioMine.setChecked(true);
                break;
            default:
                break;
        }
    }

    private void resetCheckedState() {
        radioHome.setChecked(false);
        radioAuthor.setChecked(false);
        radioPhoto.setChecked(false);
        radioMine.setChecked(false);
    }

    @OnClick({R.id.radio_home,R.id.radio_author,R.id.radio_photo,R.id.radio_mine})
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.radio_home:
                viewPager.setCurrentItem(0);
                break;

            case R.id.radio_author:
                viewPager.setCurrentItem(1);
                break;

            case R.id.radio_photo:
                viewPager.setCurrentItem(2);
                break;

            case R.id.radio_mine:
                viewPager.setCurrentItem(3);
                break;

            default:
                break;
        }
    }

    @Override
    public void onPageScrollStateChanged(int i) {

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unbinder.unbind();
    }

}
