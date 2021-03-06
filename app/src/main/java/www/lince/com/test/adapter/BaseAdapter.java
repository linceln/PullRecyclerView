package www.lince.com.test.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import www.lince.com.test.viewholder.FooterViewHolder;
import www.lince.com.test.viewholder.ItemViewHolder;
import www.lince.com.test.R;

public abstract class BaseAdapter<T> extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private static final int VIEW_ITEM = 0;
    private static final int VIEW_PROGRESS = 1;
    private Context context;
    private List<T> list;
    private boolean isLoadMoreEnabled = false;

    public BaseAdapter(Context context, List<T> list) {

        this.list = list;
        this.context = context;
    }

    @Override
    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        RecyclerView.ViewHolder viewHolder = null;
        if (viewType == VIEW_ITEM) {
            View view = LayoutInflater.from(context).inflate(getItemLayoutId(), parent, false);
            viewHolder = new ItemViewHolder(view);
        } else if (viewType == VIEW_PROGRESS) {
            View view = LayoutInflater.from(context).inflate(R.layout.progress_item, parent, false);
            viewHolder = new FooterViewHolder(view);
        }
        return viewHolder;
    }

    @Override
    public final void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

        if (isLoadMoreEnabled) {
            if (position == list.size()) {
                return;
            }
        }

        if (holder.itemView.getLayoutParams() instanceof StaggeredGridLayoutManager.LayoutParams) {
            StaggeredGridLayoutManager.LayoutParams params = (StaggeredGridLayoutManager.LayoutParams) holder.itemView.getLayoutParams();
            params.setFullSpan(true);
        }

        if (holder instanceof ItemViewHolder) {
            ItemViewHolder itemViewHolder = (ItemViewHolder) holder;
            convert(itemViewHolder, list.get(position), position);
        } else if (holder instanceof FooterViewHolder) {
        }
    }

    @Override
    public final int getItemCount() {

        if (isLoadMoreEnabled) {
            return list == null ? 0 : list.size() + 1;
        } else {
            return list == null ? 0 : list.size();
        }

    }

    @Override
    public final int getItemViewType(int position) {

        if (isLoadMoreEnabled) {
            if (position == getItemCount() - 1) {
                return VIEW_PROGRESS;
            } else {
                return VIEW_ITEM;
            }
        } else {
            return VIEW_ITEM;
        }
    }

    public abstract void convert(ItemViewHolder holder, T item, int position);

    /**
     * 获得行布局的id
     *
     * @return 行布局的id
     */
    public abstract int getItemLayoutId();

    public boolean isPullUpEnabled() {

        return isLoadMoreEnabled;
    }

    /**
     * 是否可以上拉加载更多
     *
     * @param b
     */
    public void setPullUpEnabled(boolean b) {

        isLoadMoreEnabled = b;
    }

    /**
     * 上拉加载完成调用
     */
    public void onRefreshCompleted() {

        if (isLoadMoreEnabled) {
            notifyItemRemoved(getItemCount());
        }
    }

    /**
     * 是否在Footer的位置
     *
     * @param position
     * @return
     */
    public boolean isFooterPosition(int position) {
        return isPullUpEnabled() && position == getItemCount() - 1;
    }
}
