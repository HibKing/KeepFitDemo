package xx.hw.hwgame.main.adapter;

import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseMultiItemQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.youth.banner.Banner;

import java.util.ArrayList;
import java.util.List;

import xx.hw.hwgame.R;
import xx.hw.hwgame.main.GlideImageLoader;
import xx.hw.hwgame.main.module.MainItem;

public class MainAdapter extends BaseMultiItemQuickAdapter<MainItem, BaseViewHolder> {
    public MainAdapter(List data) {
        super(data);
        // 绑定 layout 对应的 type
        addItemType(MainItem.BANNER, R.layout.item_banner);
        addItemType(MainItem.MESSAGE, R.layout.item_main_message);
    }

    @Override
    protected void convert(@NonNull BaseViewHolder helper, MainItem item) {
        // 根据返回的 type 分别设置数据
        switch (helper.getItemViewType()) {
            case MainItem.BANNER:
                Banner banner = (Banner)helper.getView(R.id.banner);
                //设置图片加载器
                banner.setImageLoader(new GlideImageLoader());
                //设置图片集合
                List<Integer> images=new ArrayList<>();
                images.add(R.drawable.a);
                images.add(R.drawable.b);
                images.add(R.drawable.c);
                images.add(R.drawable.d);
                banner.setImages(images);
                //banner设置方法全部调用完毕时最后调用
                banner.start();
                break;
            case MainItem.MESSAGE:
                try {
                    ImageView imageView=(ImageView)helper.getView(R.id.main_message_img);
                    TextView title=(TextView)helper.getView(R.id.main_message_title);
                    TextView content=(TextView)helper.getView(R.id.main_message_content);
                    Glide.with(mContext).load(item.getMessageItem().getImgUrl()).into(imageView);
                    title.setText(item.getMessageItem().getTitle());
                    content.setText(item.getMessageItem().getContent());
                }catch (Exception e){
                    e.printStackTrace();
                }

                break;

            default:
                break;
        }
    }
}
