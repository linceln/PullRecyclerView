package www.lince.com.test;

import android.support.v7.widget.RecyclerView;

import www.lince.com.test.adapter.BaseAdapter;


/**
 * Created by Stay on 5/3/16.
 * Powered by www.stay4it.com
 */
public interface ILayoutManager {

    RecyclerView.LayoutManager getLayoutManager();

    int orientation();

//    int findLastVisiblePosition();

    void setUpAdapter(BaseAdapter adapter);
}
