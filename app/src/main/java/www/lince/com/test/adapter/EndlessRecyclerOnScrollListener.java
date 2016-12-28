package www.lince.com.test.adapter;

import android.support.v7.widget.RecyclerView;

public abstract class EndlessRecyclerOnScrollListener extends RecyclerView.OnScrollListener {

//    private RecyclerView.LayoutManager mLayoutManager;
//
//    private BaseAdapter mAdapter;

    //当前页，从1开始
    private int currentPage = 1;

//    public EndlessRecyclerOnScrollListener(RecyclerView.LayoutManager layoutManager, BaseAdapter adapter) {
//
//        mLayoutManager = layoutManager;
//        mAdapter = adapter;
//    }

    @Override
    public void onScrollStateChanged(RecyclerView recyclerView, int newState) {

        super.onScrollStateChanged(recyclerView, newState);

//        if (mLayoutManager.orientation() == LinearLayoutManager.VERTICAL) {
        if (newState == RecyclerView.SCROLL_STATE_IDLE && recyclerView.canScrollVertically(-1)) {
            onNextPage(currentPage);
        }
//        }
//        else if (mLayoutManager.orientation() == LinearLayoutManager.HORIZONTAL) {
//            if (newState == RecyclerView.SCROLL_STATE_IDLE && recyclerView.canScrollHorizontally(-1)) {
//                onNextPage(currentPage);
//            }
//        } else if (mLayoutManager.orientation() == StaggeredGridLayoutManager.VERTICAL) {
//
//        } else if (mLayoutManager.orientation() == StaggeredGridLayoutManager.HORIZONTAL) {
//
//        }

//        if (newState == RecyclerView.SCROLL_STATE_IDLE && mAdapter.isPullUpEnabled() && checkIfNeedLoadMore()) {
//            onNextPage(currentPage);
//        }
    }

    @Override
    public void onScrolled(RecyclerView recyclerView, int dx, int dy) {

        super.onScrolled(recyclerView, dx, dy);
    }

//    private boolean checkIfNeedLoadMore() {
//        int lastVisibleItemPosition = ((LinearLayoutManager) mLayoutManager).findLastVisibleItemPosition();
//        int totalCount = mLayoutManager.getItemCount();
//        return totalCount - lastVisibleItemPosition < 5;
//    }

    public abstract void onNextPage(int currentPage);
}

