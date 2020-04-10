package xx.hw.hwgame.mine;


import android.os.Bundle;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import xx.hw.hwgame.R;

public class MineFragment extends Fragment {
    private static MineFragment mineFragment;
    public View onCreateView(LayoutInflater inflater, ViewGroup container, final Bundle savedInstanceState) {
        final View root = inflater.inflate(R.layout.fragment_mine, container, false);
        return root;
    }

    public static MineFragment getInstance() {
        if (mineFragment == null) {
           mineFragment = new MineFragment();
        }
        return mineFragment;
    }
}
