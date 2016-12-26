package www.lince.com.test;

import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements SwipeRefreshLayout.OnRefreshListener, RecyclerManager.OnLoadMoreListener {

    private List<String> mList = new ArrayList<>();

    private SwipeRefreshLayout mSwipeRefreshLayout;

    private RecyclerManager mRecyclerManager;
    private int j = 0;
    private int i = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initUI();
        initData();
    }

    private void initUI() {

        // 下拉刷新
        mSwipeRefreshLayout = (SwipeRefreshLayout) findViewById(R.id.swipeRefreshLayout);
        mSwipeRefreshLayout.setOnRefreshListener(this);

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recylcerView);
        mRecyclerManager = RecyclerManager.setupRecyclerView(this, recyclerView, new RefreshAdapter(this, mList));
        mRecyclerManager.setLoadMoreEnabled(true);
        // 下拉加载更多
        mRecyclerManager.setOnLoadMoreListener(this);
    }

    private void initData() {

        for (int i = 0; i < 50; i++) {
            mList.add("第" + i + "个");
        }
        mRecyclerManager.notifyDataSetChanged();
    }

    @Override
    public void onRefresh() {

        mSwipeRefreshLayout.setRefreshing(false);
        j++;
        mList.add(0, "下拉刷新" + j);
        mRecyclerManager.getAdapter().notifyDataSetChanged();
    }

    @Override
    public void onLoadMore(int currentPage) {

        mSwipeRefreshLayout.postDelayed(new Runnable() {
            @Override
            public void run() {
                i++;
                mList.add("上拉加载更多" + i);
//                mList.add("上拉加载更多" + i);
//                mList.add("上拉加载更多" + i);
//                mList.add("上拉加载更多" + i);
//                mList.add("上拉加载更多" + i);
//                mList.add("上拉加载更多" + i);
//                mList.add("上拉加载更多" + i);
                mRecyclerManager.onLoadMoreCompleted();
//                mRecyclerManager.setLoadMoreEnabled(false);
            }
        }, 2000);
    }
}
