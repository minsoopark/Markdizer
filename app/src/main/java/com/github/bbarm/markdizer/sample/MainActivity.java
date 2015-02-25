package com.github.bbarm.markdizer.sample;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.github.bbarm.markdizer.Markdizer;
import com.github.bbarm.markdizer.R;


public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView normal = (TextView) findViewById(R.id.txt_normal);
        TextView bold = (TextView) findViewById(R.id.txt_bold);
        TextView italic = (TextView) findViewById(R.id.txt_italic);
        TextView underlined = (TextView) findViewById(R.id.txt_underlined);
        TextView red = (TextView) findViewById(R.id.txt_red);
        TextView mixed = (TextView) findViewById(R.id.txt_mixed);

        normal.setText(Markdizer.markdize(getString(R.string.hello_world)));
        bold.setText(Markdizer.markdize(getString(R.string.hello_world_bold)));
        italic.setText(Markdizer.markdize(getString(R.string.hello_world_italic)));
        underlined.setText(Markdizer.markdize(getString(R.string.hello_world_underlined)));
        red.setText(Markdizer.markdize(getString(R.string.hello_world_red)));
        mixed.setText(Markdizer.markdize(getString(R.string.hello_world_mixed)));
    }
}
