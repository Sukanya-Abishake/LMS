package com.elearning.lmsapp;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import com.elearning.util.ValidationUtil;

import static com.elearning.util.ValidationUtil.isValidPassword;
import static android.os.ParcelFileDescriptor.MODE_APPEND;

public class HomeActivity extends AppCompatActivity implements OnClickListener {

    private TextView heading;
    private Button btDashboard, btCourse, btAboutus;
    private View mView;
    private String userName, password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_activity);

        mView = findViewById(R.id.body_content);
        heading = findViewById(R.id.heading);
        btDashboard = findViewById(R.id.bt_dashboard);
        btCourse = findViewById(R.id.bt_Course);
        btAboutus = findViewById(R.id.bt_AboutUs);
        heading.setText("Dashboard");

        btAboutus.setOnClickListener(this);
        btDashboard.setOnClickListener(this);
        btCourse.setOnClickListener(this);
        getuserDetails();
        onDashboard();


    }

    @Override
    protected void onStart() {
        super.onStart();

    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    public void exit() {
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
        // Setting Alert Dialog Title
        alertDialogBuilder.setTitle("Confirm Exit..!!!");
        // Icon Of Alert Dialog
        //alertDialogBuilder.setIcon(R.drawable.question);
        // Setting Alert Dialog Message
        alertDialogBuilder.setMessage("Are you sure,You want to exit");
        alertDialogBuilder.setCancelable(false);

        alertDialogBuilder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface arg0, int arg1) {

                finish();
            }
        });

        alertDialogBuilder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(HomeActivity.this, "You clicked over No", Toast.LENGTH_SHORT).show();
            }
        });
        alertDialogBuilder.setNeutralButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(getApplicationContext(), "You clicked on Cancel", Toast.LENGTH_SHORT).show();
            }
        });

        AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.show();
    }


    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch (id) {
            case R.id.bt_dashboard:
                onDashboard();
                break;
            case R.id.bt_Course:
                onCourse();
                break;
            case R.id.bt_AboutUs:
                heading.setText("About Us");
                onAboutus();
                break;

        }
    }

    private boolean isValidateLoginInfoFields() {
        boolean isValidData = true;
        EditText etEmail = findViewById(R.id.username);
        EditText etpassword = findViewById(R.id.password);
        TextView tvErrormessage = findViewById(R.id.tv_errormessage);

        if (!ValidationUtil.isValidEmail(etEmail.getText().toString())) {
            isValidData = false;
            etEmail.setActivated(true);
        }
        if (!isValidPassword(etpassword.getText().toString())) {
            isValidData = false;
            etpassword.setActivated(true);
        }
        tvErrormessage.setText("Please correct the invalid fields");
        return isValidData;

    }


    private void onDashboard() {
        heading.setText("Dashboard");
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        // Replace the contents of the container with the new fragment
        //DashboardFragment  = new DashboardFragment();
        ft.replace(R.id.body_content, DashboardFragment.newInstance(userName,password));
        // or ft.add(R.id.your_placeholder, new FooFragment());
        // Complete the changes added above
        ft.commit();
    }

    private void onCourse() {
        heading.setText("Course");
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        // Replace the contents of the container with the new fragment
        ft.replace(R.id.body_content, new CourseFragment());
        // or ft.add(R.id.your_placeholder, new FooFragment());
        // Complete the changes added above
        ft.commit();
    }

    private void onAboutus() {
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        // Replace the contents of the container with the new fragment
        ft.replace(R.id.body_content, new AboutUsFragment());
        // or ft.add(R.id.your_placeholder, new FooFragment());
        // Complete the changes added above
        ft.commit();
    }

    private void getuserDetails() {
        SharedPreferences sh = getSharedPreferences("LMSPref", MODE_PRIVATE);

        // The value will be default as empty string because for
        // the very first time when the app is opened, there is nothing to show
        userName = sh.getString("username", "");
        password = sh.getString("password", "");

    }
}