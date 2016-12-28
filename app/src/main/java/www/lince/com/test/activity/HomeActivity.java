package www.lince.com.test.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import www.lince.com.test.R;

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
        startActivity(new Intent(this, GridLayoutManagerActivity.class));
    }

    public void gotoStaggerLayoutManager(View v) {
        startActivity(new Intent(this, StaggerLayoutManagerActivity.class));
    }
}
