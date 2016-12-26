package www.lince.com.test;

import android.support.v7.widget.RecyclerView;

public abstract class EndlessRecyclerOnScrollListener extends RecyclerView.OnScrollListener {

    private ILayoutManager mLayoutManager;

    private BaseAdapter mAdapter;

    //当前页，从1开始
    private int currentPage = 1;

    public EndlessRecyclerOnScrollListener(ILayoutManager layoutManager, BaseAdapter adapter) {

        mLayoutManager = layoutManager;
        mAdapter = adapter;
    }

    @Override
    public void onScrollStateChanged(RecyclerView recyclerView, int newState) {

        super.onScrollStateChanged(recyclerView, newState);
        if (newState == RecyclerView.SCROLL_STATE_IDLE && mAdapter.isLoadMoreEnabled() && checkIfNeedLoadMore()) {
            onLoadMore(currentPage);
        }
    }

    @Override
    public void onScrolled(RecyclerView recyclerView, int dx, int dy) {

        super.onScrolled(recyclerView, dx, dy);
    }

    private boolean checkIfNeedLoadMore() {
        int lastVisibleItemPosition = mLayoutManager.findLastVisiblePosition();
        int totalCount = mLayoutManager.getLayoutManager().getItemCount();
        return totalCount - lastVisibleItemPosition < 5;
    }

    public abstract void onLoadMore(int currentPage);

}

