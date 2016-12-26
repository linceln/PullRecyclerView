package www.lince.com.test;

import android.content.Context;

import java.util.List;

public class RefreshAdapter extends BaseAdapter<String> {

    public RefreshAdapter(Context context, List<String> list) {

        super(context, list);
    }

    @Override
    public int getItemLayoutId() {

        return android.R.layout.simple_list_item_1;
    }

    @Override
    public void convert(ItemViewHolder holder, String item, int position) {

        holder.setText(android.R.id.text1, item);
    }
}
