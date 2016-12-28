package www.lince.com.test.activity;

import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

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

public class LinearLayoutManagerActivity extends AppCompatActivity implements SwipeRefreshLayout.OnRefreshListener {

    private List<GankEntity.ResultsBean> mList = new ArrayList<>();

    private SwipeRefreshLayout mSwipeRefreshLayout;
    private RefreshAdapter adapter;
    private LinearLayoutManager layoutManager;
    private RecyclerView recyclerView;
    private int page = 1;

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

        recyclerView = (RecyclerView) findViewById(R.id.recylcerView);
        layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
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

//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        MenuItem item = menu.add("Horizontal");
//        item.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
//            @Override
//            public boolean onMenuItemClick(MenuItem item) {
//                if (item.getTitle().equals("Horizontal")) {
//                    item.setTitle("Vertical");
//                    layoutManager = new LinearLayoutManager(LinearLayoutManagerActivity.this, LinearLayoutManager.HORIZONTAL, false);
//                    recyclerView.setLayoutManager(layoutManager);
//                    adapter.notifyDataSetChanged();
//
//                } else if (item.getTitle().equals("Vertical")) {
//                    item.setTitle("Horizontal");
//                    layoutManager = new LinearLayoutManager(LinearLayoutManagerActivity.this, LinearLayoutManager.VERTICAL, false);
//                    recyclerView.setLayoutManager(layoutManager);
//                    adapter.notifyDataSetChanged();
//                }
//                return false;
//            }
//        });
//        item.setShowAsAction(MenuItem.SHOW_AS_ACTION_ALWAYS);
//        return super.onCreateOptionsMenu(menu);
//    }
}
