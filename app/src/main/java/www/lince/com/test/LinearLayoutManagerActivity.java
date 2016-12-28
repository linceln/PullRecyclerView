package www.lince.com.test;

import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class LinearLayoutManagerActivity extends AppCompatActivity implements SwipeRefreshLayout.OnRefreshListener {

    private List<String> mList = new ArrayList<>();

    private SwipeRefreshLayout mSwipeRefreshLayout;

    private int i = 0;
    private RefreshAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_linear_layout_manager);
        initUI();
        initData();
    }

    private void initUI() {

        // 下拉刷新
        mSwipeRefreshLayout = (SwipeRefreshLayout) findViewById(R.id.swipeRefreshLayout);
        mSwipeRefreshLayout.setOnRefreshListener(this);

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recylcerView);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        adapter = new RefreshAdapter(this, mList);
        adapter.setPullUpEnabled(true);
        recyclerView.setAdapter(adapter);
//        layoutManager.setUpAdapter(adapter);

        recyclerView.addOnScrollListener(new EndlessRecyclerOnScrollListener(layoutManager, adapter) {

            @Override
            public void onNextPage(int currentPage) {

                if (adapter.isPullUpEnabled()) {
                    // Load more
                    mSwipeRefreshLayout.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            i++;
                            mList.add("上拉加载更多" + i);
                            adapter.onRefreshCompleted();
                        }
                    }, 2000);
                }
            }
        });
    }

    private void initData() {
        for (int i = 0; i < 50; i++) {
            mList.add("第" + i + "个");
        }
        adapter.notifyDataSetChanged();
        mSwipeRefreshLayout.setRefreshing(false);
    }

    @Override
    public void onRefresh() {
        mList.clear();
        initData();
    }
}
