package com.wallet.koinlocker;

import android.support.v4.app.NavUtils;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.RelativeLayout;

import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.series.BarGraphSeries;
import com.jjoe64.graphview.series.DataPoint;
import com.wallet.koinlocker.fragments.AccountFragment;
import com.wallet.koinlocker.fragments.SendAndReceiveFragment;
import com.wallet.koinlocker.fragments.SettingsFragment;
import com.wallet.koinlocker.listeners.OnSwipeTouchListener;

public class AccountDetailsActivity extends AppCompatActivity {

    BarGraphSeries<DataPoint> series;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account_details);

        String accountName = "Account #" + getIntent().getIntExtra("click_position",1);

        GraphView graph = (GraphView) findViewById(R.id.transactions_graph);
        series = new BarGraphSeries<DataPoint>(new DataPoint[]{
                new DataPoint(0,0.5),
                new DataPoint(1, 0.14),
                new DataPoint(2, -0.28),
                new DataPoint(3, 0.34),
        });
        graph.addSeries(series);
        series.setSpacing(0);

        // Back button
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle(accountName);
        //getSupportActionBar().setDisplayUseLogoEnabled(true);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            // Respond to the action bar's Up/Home button
            case android.R.id.home:
                NavUtils.navigateUpFromSameTask(this);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
