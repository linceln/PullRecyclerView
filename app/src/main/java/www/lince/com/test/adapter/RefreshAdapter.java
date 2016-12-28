package www.lince.com.test.adapter;

import android.content.Context;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import java.util.List;

import www.lince.com.test.R;
import www.lince.com.test.request.GankEntity;
import www.lince.com.test.viewholder.ItemViewHolder;

public class RefreshAdapter extends BaseAdapter<GankEntity.ResultsBean> {

    private Context context;

    public RefreshAdapter(Context context, List<GankEntity.ResultsBean> list) {

        super(context, list);
        this.context = context;
    }

    @Override
    public int getItemLayoutId() {

        return R.layout.recycler_item;
    }

    @Override
    public void convert(ItemViewHolder holder, GankEntity.ResultsBean item, int position) {

//        holder.setText(android.R.id.text1, item);
        ImageView view = (ImageView) holder.getView(R.id.iv);
        Glide.with(context)
                .load(item.getUrl())
                .placeholder(R.mipmap.ic_launcher)
                .into(view);
    }
}
