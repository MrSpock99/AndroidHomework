package apps.robot.homework_1;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class ProfileActivity extends AppCompatActivity {
    public static final int EDIT_PROFILE_REQUEST_CODE = 1001;
    public static final int SEND_REQUEST_CODE = 1002;

    public static final String EXTRA_NAME = "EXTRA_NAME";
    public static final String EXTRA_EMAIL = "EXTRA_EMAIL";
    public static final String EXTRA_PHONE_NUMBER = "EXTRA_PHONE_NUMBER";

    private TextView tv_name;
    private TextView tv_email;
    private TextView tv_phone_number;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        init();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode) {
            case EDIT_PROFILE_REQUEST_CODE:
                if (resultCode == Activity.RESULT_OK) {
                    String name = data.getStringExtra(EXTRA_NAME);
                    String email = data.getStringExtra(EXTRA_EMAIL);
                    String phone_number = data.getStringExtra(EXTRA_PHONE_NUMBER);

                    tv_name.setText(name);
                    tv_email.setText(email);
                    tv_phone_number.setText(phone_number);

                }else if (resultCode == Activity.RESULT_CANCELED){
                    Toast.makeText(this, R.string.toast_cancel_message,Toast.LENGTH_SHORT).show();
                }
                break;
            case SEND_REQUEST_CODE:
                if (resultCode == Activity.RESULT_OK) {
                    Toast.makeText(this, R.string.toast_success_message, Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(this, R.string.toast_error_message, Toast.LENGTH_SHORT).show();
                }
                break;
        }

    }

    public void OnBtnEditClicked(View view) {
        Intent intent = new Intent(ProfileActivity.this, EditProfileActivity.class);
        startActivityForResult(intent, EDIT_PROFILE_REQUEST_CODE);
    }

    public void onBtnSendClicked(View view) {
        Intent sendIntent = new Intent();

        sendIntent.setAction(Intent.ACTION_SEND);
        sendIntent.putExtra(Intent.EXTRA_TEXT, getUserInformation());
        sendIntent.setType("text/plain");

        if (sendIntent.resolveActivity(getPackageManager()) != null) {
            startActivityForResult(sendIntent, SEND_REQUEST_CODE);
        }
    }

    private void init() {
        tv_name = findViewById(R.id.tv_username);
        tv_email = findViewById(R.id.tv_user_email);
        tv_phone_number = findViewById(R.id.tv_user_phone_number);
    }

    private String getUserInformation() {
        return tv_name.getText().toString() + "\n" +
                tv_email.getText().toString() + "\n" +
                tv_phone_number.getText().toString();
    }


}
