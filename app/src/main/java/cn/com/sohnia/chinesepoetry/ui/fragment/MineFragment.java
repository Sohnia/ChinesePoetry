package cn.com.sohnia.chinesepoetry.ui.fragment;

import android.content.Intent;
import android.view.View;

import butterknife.ButterKnife;
import butterknife.OnClick;
import cn.com.sohnia.chinesepoetry.R;
import cn.com.sohnia.chinesepoetry.ui.activity.LoginActivity;
import cn.com.sohnia.chinesepoetry.ui.base.BaseFragment;
import cn.com.sohnia.chinesepoetry.ui.presenter.MineFragmentPresenter;
import cn.com.sohnia.chinesepoetry.ui.view.IMineFragment;

public class MineFragment extends BaseFragment
        <IMineFragment, MineFragmentPresenter> {

    @Override
    protected MineFragmentPresenter createPresenter() {
        return new MineFragmentPresenter(getContext());
    }
    @Override
    protected int createViewLayoutId() {
        return R.layout.fragment_mine;
    }
    @Override
    protected void initView(View rootView) {
        ButterKnife.bind(this, rootView);
    }

    @OnClick({R.id.login_linear,R.id.history_linear ,R.id.my_store , R.id.skin,
            R.id.suggestion,R.id.clear_cache,R.id.about})
    public void onClickView(View v){
        switch(v.getId()){
            case R.id.login_linear:
                Intent intent = new Intent(getActivity(),LoginActivity.class);
                startActivity(intent);
                case R.id.history_linear:
                // TODO: 2019/1/6
                    break;
                case R.id.my_store:
                // TODO: 2019/1/6
                    break;
                case R.id.skin:
                // TODO: 2019/1/6
                    break;
                case R.id.suggestion:
                // TODO: 2019/1/6
                    break;
                case R.id.clear_cache:
                // TODO: 2019/1/6
                    break;
                case R.id.about:
                // TODO: 2019/1/6
                    break;
                default:
                    break;

        }
    }
}
