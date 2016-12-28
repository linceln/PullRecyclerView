package www.lince.com.test.viewholder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.RatingBar;
import android.widget.TextView;

public class ItemViewHolder extends RecyclerView.ViewHolder {

    public ItemViewHolder(View itemView) {

        super(itemView);
    }

//    public void setImageUrl(int viewId, String url) {
//
//        SimpleDraweeView cover = (SimpleDraweeView) itemView.findViewById(viewId);
//        Uri uri = Uri.parse(url);
//        cover.setImageURI(uri);
//    }

    public void setText(int viewId, String text) {

        TextView textView = (TextView) itemView.findViewById(viewId);
        textView.setText(text);
    }

    public void setOnClickListener(int viewId, View.OnClickListener listener) {

        View view = itemView.findViewById(viewId);
        view.setOnClickListener(listener);
    }

    public void setVisibility(int viewId, int visibility) {

        itemView.findViewById(viewId).setVisibility(visibility);
    }

    public void setRating(int viewId, float rating) {

        ((RatingBar) itemView.findViewById(viewId)).setRating(rating);
    }

    public View getView(int resId) {

        return itemView.findViewById(resId);
    }
}
