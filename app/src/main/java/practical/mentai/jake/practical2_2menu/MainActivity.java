package practical.mentai.jake.practical2_2menu;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView mainTextView;
    private DisplayMetrics screenDPI;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //Get main text view ID
        mainTextView = findViewById(R.id.TextView_main_text);
        screenDPI = getResources().getDisplayMetrics();

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }else if(id == R.id.action_zoom_in){
            increaseFontSize();
        }else if(id == R.id.action_zoom_out){
            decreaseFontSize();
        }else if(id == R.id.action_about_us){
            Intent intent = new Intent(this, AboutUsActivity.class);
            startActivity(intent);
        }

        return super.onOptionsItemSelected(item);
    }

    private void increaseFontSize(){
        float fontSize = (mainTextView.getTextSize() / screenDPI.scaledDensity) + 2;

        mainTextView.setTextSize(fontSize);

    }

    private void decreaseFontSize(){
        float fontSize =(mainTextView.getTextSize() / screenDPI.scaledDensity) - 2;
        if(fontSize <= 14){
            fontSize = 14;
        }
        mainTextView.setTextSize(fontSize);
    }
}
