package xx.hw.hwgame.main.view;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import java.util.ArrayList;
import java.util.List;

import xx.hw.hwgame.R;
import xx.hw.hwgame.databinding.FragmentMainBinding;
import xx.hw.hwgame.main.adapter.MainAdapter;
import xx.hw.hwgame.main.module.MainItem;
import xx.hw.hwgame.main.module.MessageItem;


public class MainFragment extends Fragment{
    private FragmentMainBinding fragmentMainBinding;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, final Bundle savedInstanceState) {
        fragmentMainBinding = fragmentMainBinding.inflate(inflater, container, false);
        List data=new ArrayList();
        data.add(new MainItem(1));
        data.add(new MainItem(2,new MessageItem(R.drawable.m1,"测试标题","测试内容2，你想改成什么就是什么")));
        data.add(new MainItem(2,new MessageItem(R.drawable.m2,"测试标题","测试内容2，你想改成什么就是什么")));
        data.add(new MainItem(2,new MessageItem(R.drawable.m3,"测试标题","测试内容2，你想改成什么就是什么")));
        data.add(new MainItem(2,new MessageItem(R.drawable.m4,"测试标题","测试内容2，你想改成什么就是什么")));
        data.add(new MainItem(2,new MessageItem(R.drawable.m5,"测试标题","测试内容2，你想改成什么就是什么")));
        MainAdapter mainAdapter=new MainAdapter(data);
        fragmentMainBinding.mainRv.setLayoutManager(new LinearLayoutManager(getActivity()));
        fragmentMainBinding.mainRv.setAdapter(mainAdapter);
        return fragmentMainBinding.getRoot();
    }
}
