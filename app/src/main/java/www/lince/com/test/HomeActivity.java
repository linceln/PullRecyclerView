package www.lince.com.test;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
    }

    public void gotoLinearLayoutManager(View v) {
        startActivity(new Intent(this, LinearLayoutManagerActivity.class));
    }

    public void gotoGridLayoutManager(View v) {

    }

    public void gotoStaggerLayoutManager(View v) {

    }
}
