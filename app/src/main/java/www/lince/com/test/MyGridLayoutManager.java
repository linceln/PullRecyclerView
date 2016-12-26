package www.lince.com.test;

import android.content.Context;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;


/**
 * Created by Stay on 5/3/16.
 * Powered by www.stay4it.com
 */
public class MyGridLayoutManager extends GridLayoutManager implements ILayoutManager {

    public MyGridLayoutManager(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    public MyGridLayoutManager(Context context, int spanCount) {
        super(context, spanCount);
    }

    public MyGridLayoutManager(Context context, int spanCount, int orientation, boolean reverseLayout) {
        super(context, spanCount, orientation, reverseLayout);
    }


    @Override
    public RecyclerView.LayoutManager getLayoutManager() {
        return this;
    }

    @Override
    public int findLastVisiblePosition() {
        return findLastVisibleItemPosition();
    }

    @Override
    public void setUpAdapter(BaseAdapter adapter) {
        FooterSpanSizeLookup footerSpanSizeLookup = new FooterSpanSizeLookup(adapter, getSpanCount());
        setSpanSizeLookup(footerSpanSizeLookup);
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
}
