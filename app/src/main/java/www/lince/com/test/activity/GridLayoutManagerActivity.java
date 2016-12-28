package www.lince.com.test.activity;

import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import www.lince.com.test.R;
import www.lince.com.test.adapter.BaseAdapter;
import www.lince.com.test.adapter.EndlessRecyclerOnScrollListener;
import www.lince.com.test.adapter.RefreshAdapter;
import www.lince.com.test.request.Business;
import www.lince.com.test.request.GankEntity;

public class GridLayoutManagerActivity extends AppCompatActivity implements SwipeRefreshLayout.OnRefreshListener {
    private List<GankEntity.ResultsBean> mList = new ArrayList<>();

    private SwipeRefreshLayout mSwipeRefreshLayout;
    private RefreshAdapter adapter;
    private GridLayoutManager layoutManager;
    private RecyclerView recyclerView;
    private int page = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grid_layout_manager);
        initUI();
        initData();
    }

    public class FooterSpanSizeLookup extends GridLayoutManager.SpanSizeLookup {
        private BaseAdapter adapter;
        private int spanCount;

        public FooterSpanSizeLookup(BaseAdapter adapter, int spanCount) {
            this.adapter = adapter;
            this.spanCount = spanCount;
        }

        @Override
        public int getSpanSize(int position) {
            // 显示
            if (adapter.isFooterPosition(position)) {
                return spanCount;
            }
            return 1;
        }
    }

    private void initUI() {

        // 下拉刷新
        mSwipeRefreshLayout = (SwipeRefreshLayout) findViewById(R.id.swipeRefreshLayout);
        mSwipeRefreshLayout.setOnRefreshListener(this);

        recyclerView = (RecyclerView) findViewById(R.id.recylcerView);
        layoutManager = new GridLayoutManager(this, 2, LinearLayoutManager.VERTICAL, false);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        adapter = new RefreshAdapter(this, mList);
        adapter.setPullUpEnabled(true);
        layoutManager.setSpanSizeLookup(new FooterSpanSizeLookup(adapter, 2));
        recyclerView.setAdapter(adapter);

        recyclerView.addOnScrollListener(new EndlessRecyclerOnScrollListener() {

            @Override
            public void onNextPage(int currentPage) {

                if (adapter.isPullUpEnabled()) {
                    // Load more
                    page++;
                    initData();
                }
            }
        });
    }

    private void initData() {

        Business.getGank(page, new Callback<GankEntity>() {
            @Override
            public void onResponse(Call<GankEntity> call, Response<GankEntity> response) {
                mSwipeRefreshLayout.setRefreshing(false);
                adapter.onRefreshCompleted();
                if (response.isSuccessful()) {
                    GankEntity entity = response.body();
                    mList.addAll(entity.getResults());
                }
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<GankEntity> call, Throwable t) {
                mSwipeRefreshLayout.setRefreshing(false);
                adapter.onRefreshCompleted();
            }
        });
    }

    @Override
    public void onRefresh() {
        mList.clear();
        page = 1;
        initData();
    }
}
