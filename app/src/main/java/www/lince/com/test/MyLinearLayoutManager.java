package www.lince.com.test;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;

import www.lince.com.test.adapter.BaseAdapter;


/**
 * Created by Stay on 5/3/16.
 * Powered by www.stay4it.com
 */
public class MyLinearLayoutManager extends LinearLayoutManager implements ILayoutManager {

    public MyLinearLayoutManager(Context context) {
        super(context);
    }

    public MyLinearLayoutManager(Context context, int orientation, boolean reverseLayout) {
        super(context, orientation, reverseLayout);
    }

    public MyLinearLayoutManager(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    @Override
    public RecyclerView.LayoutManager getLayoutManager() {
        return this;
    }

    @Override
    public int orientation() {
        return getOrientation();
    }


//    @Override
//    public int findLastVisiblePosition() {
//        return findLastVisibleItemPosition();
//    }

    @Override
    public void setUpAdapter(BaseAdapter adapter) {
    }
}
