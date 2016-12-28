package www.lince.com.test.activity;

import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import www.lince.com.test.R;
import www.lince.com.test.adapter.EndlessRecyclerOnScrollListener;
import www.lince.com.test.adapter.RefreshAdapter;
import www.lince.com.test.request.Business;
import www.lince.com.test.request.GankEntity;

public class StaggerLayoutManagerActivity extends AppCompatActivity implements SwipeRefreshLayout.OnRefreshListener {
    private List<GankEntity.ResultsBean> mList = new ArrayList<>();

    private SwipeRefreshLayout mSwipeRefreshLayout;
    private RefreshAdapter adapter;
    private StaggeredGridLayoutManager layoutManager;
    private RecyclerView recyclerView;
    private int page = 1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stagger_layout_manager);
        initUI();
        initData();
    }

    private void initUI() {

        // 下拉刷新
        mSwipeRefreshLayout = (SwipeRefreshLayout) findViewById(R.id.swipeRefreshLayout);
        mSwipeRefreshLayout.setOnRefreshListener(this);

        recyclerView = (RecyclerView) findViewById(R.id.recylcerView);
        layoutManager = new StaggeredGridLayoutManager(3, StaggeredGridLayoutManager.VERTICAL);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        adapter = new RefreshAdapter(this, mList);
        adapter.setPullUpEnabled(true);
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
