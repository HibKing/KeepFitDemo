package xx.hw.hwgame.main.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;
import 	androidx.fragment.app.FragmentManager;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Window;

import com.ashokvarma.bottomnavigation.BottomNavigationBar;
import com.ashokvarma.bottomnavigation.BottomNavigationItem;

import xx.hw.hwgame.R;
import xx.hw.hwgame.databinding.ActivityMainBinding;
import xx.hw.hwgame.mine.MineFragment;

public class MainActivity extends AppCompatActivity  implements BottomNavigationBar.OnTabSelectedListener{
    private ActivityMainBinding mActivityMainBinding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        mActivityMainBinding = ActivityMainBinding.inflate(LayoutInflater.from(this));
        setContentView(mActivityMainBinding.getRoot());
        initView();
    }

    /**
     * 初始化控件
     */
    private void initView(){
        /** 导航基础设置 包括按钮选中效果 导航栏背景色等 */
        mActivityMainBinding.bottomNavigationBar
                .setTabSelectedListener(MainActivity.this)
                .setMode(BottomNavigationBar.MODE_FIXED)
                .setBackgroundStyle(BottomNavigationBar.BACKGROUND_STYLE_DEFAULT)
                .setActiveColor("#1E90FF") //选中颜色
                .setInActiveColor("#000000") //未选中颜色
                .setBarBackgroundColor("#ffffff");//导航栏背景色

        /** 添加导航按钮 */
        mActivityMainBinding.bottomNavigationBar
                .addItem(new BottomNavigationItem(R.drawable.main_main_copm, "首页"))
                .addItem(new BottomNavigationItem(R.drawable.main_mine_community, "社区"))
                .addItem(new BottomNavigationItem(R.drawable.main_classification_icon, "分类"))
                .addItem(new BottomNavigationItem(R.drawable.main_mine_icon, "我的"))
                .setFirstSelectedPosition(0)
                .initialise(); //initialise 一定要放在 所有设置的最后一项

        setDefaultFragment();//设置默认页
    }

    /**
     * 设置默认导航栏
     */
    private void setDefaultFragment() {
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction transaction = fm.beginTransaction();
        transaction.replace(R.id.main_content,new MainFragment());
        transaction.commit();
    }



    @Override
    public void onTabSelected(int position) {
        Log.d("mydesign_debug", "onTabSelected() called with: " + "position = [" + position + "]");
        FragmentManager fm = getSupportFragmentManager();
        //开启事务
        FragmentTransaction transaction = fm.beginTransaction();
        switch (position) {
            case 0:
                Log.d("mydesign_debug", "首页");
                transaction.replace(R.id.main_content,new MainFragment());
                break;
            case 1:
                Log.d("mydesign_debug", "社区");
                transaction.replace(R.id.main_content, MineFragment.getInstance());
                break;
            case 2:
                Log.d("mydesign_debug", "分类");
                transaction.replace(R.id.main_content, MineFragment.getInstance());
                break;
            case 3:
                Log.d("mydesign_debug", "我的");
                transaction.replace(R.id.main_content, MineFragment.getInstance());
                break;

            default:
                break;
        }

        transaction.commit();// 事务提交
    }

    @Override
    public void onTabUnselected(int position) {

    }

    @Override
    public void onTabReselected(int position) {

    }
}
