package practical.mentai.jake.practical2_2menu;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import java.net.URI;

public class AboutUsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_us);
    }

    public void visitWebsite(View view){
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse("https://www.google.com"));

        //If there are no app able to handle the message
        if(intent.resolveActivity(getPackageManager()) != null){
            startActivity(intent);
        }else{
            Log.d("visitWebsite", "Unable to process intent!");
            Toast.makeText(this, "No app found to handle process",
                    Toast.LENGTH_LONG).show();
        }
    }

    public void showDial(View view){
        Intent intent = new Intent(Intent.ACTION_DIAL);
        intent.setData(Uri.parse("tel:" + "0123456789"));

        if(intent.resolveActivity(getPackageManager()) != null){
            startActivity(intent);
        }else{
            Log.d("showDial", "Unable to process intent!");
            Toast.makeText(this, "No app found to handle process",
                    Toast.LENGTH_LONG).show();
        }
    }

    public void showMain(View view){
        Intent intent = new Intent(Intent.ACTION_MAIN);
        startActivity(intent);
    }

    public void showSendTo(View view){
        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("mailto:" + "yeemh-wa16@student.tarc.edu.my"));

        if(intent.resolveActivity(getPackageManager()) != null){
            startActivity(intent);
        }else{
            Log.d("showSendTo", "Unable to process intent!");
            Toast.makeText(this, "No app found to handle process",
                    Toast.LENGTH_LONG).show();
        }
    }
}
