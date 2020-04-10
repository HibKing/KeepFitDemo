package xx.hw.hwgame.main.module;

import com.chad.library.adapter.base.entity.MultiItemEntity;

public class MainItem  implements MultiItemEntity {
    private int mItemType;
    private MessageItem messageItem;

    public static final int BANNER = 1;
    public static final int MESSAGE = 2;


    public MainItem(int itemType) {
        mItemType = itemType;
    }
    public MainItem(int itemType,MessageItem messageItem) {
        this.messageItem=messageItem;
        this.mItemType=itemType;
    }

    public MessageItem getMessageItem() {
        return messageItem;
    }

    @Override
    public int getItemType() {
        return mItemType;
    }
}
