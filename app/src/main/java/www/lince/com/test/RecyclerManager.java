package www.lince.com.test;

import android.content.Context;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.RecyclerView;

public class RecyclerManager {

    private Context context;

    private RecyclerView recyclerView;
    private BaseAdapter adapter;
    private ILayoutManager layoutManager;

    public RecyclerManager(Context context, RecyclerView recyclerView, BaseAdapter adapter) {

        this.context = context;
        this.recyclerView = recyclerView;
        this.adapter = adapter;

//        layoutManager = new MyStaggeredGridLayoutManager(3, StaggeredGridLayoutManager.VERTICAL);
//        layoutManager = new MyLinearLayoutManager(context, LinearLayoutManager.VERTICAL, false);
        layoutManager = new MyGridLayoutManager(context, 3);
        this.recyclerView.setHasFixedSize(true);
        this.recyclerView.setLayoutManager(layoutManager.getLayoutManager());
        this.recyclerView.setItemAnimator(new DefaultItemAnimator()); 
        this.recyclerView.setAdapter(adapter);
        layoutManager.setUpAdapter(adapter);
    }

    public static RecyclerManager setupRecyclerView(final Context context, final RecyclerView recyclerView, final BaseAdapter adapter) {

        return new RecyclerManager(context, recyclerView, adapter);
    }

    public RecyclerView getRecyclerView() {

        return recyclerView;
    }

    public BaseAdapter getAdapter() {

        return adapter;
    }

    public void setOnLoadMoreListener(final OnLoadMoreListener listener) {

        recyclerView.addOnScrollListener(new EndlessRecyclerOnScrollListener(layoutManager, adapter) {

            @Override
            public void onLoadMore(int currentPage) {

                if (adapter.isLoadMoreEnabled()) {
                    if (listener != null) {
                        listener.onLoadMore(currentPage);
                    }
                }
            }
        });
    }

    public void setLoadMoreEnabled(boolean b) {

        adapter.setLoadMoreEnabled(b);
    }

    public void notifyDataSetChanged() {
        adapter.notifyDataSetChanged();
    }

    public void onLoadMoreCompleted() {

        if (adapter.isLoadMoreEnabled()) {
            adapter.notifyItemRemoved(adapter.getItemCount());
        }
    }

    public interface OnLoadMoreListener {

        void onLoadMore(int currentPage);
    }
}
