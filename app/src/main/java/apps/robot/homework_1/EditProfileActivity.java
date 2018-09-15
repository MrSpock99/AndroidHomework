package apps.robot.homework_1;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class EditProfileActivity extends AppCompatActivity {
    private EditText et_name;
    private EditText et_email;
    private EditText et_phone_number;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_profile);
        init();
    }

    public void OnBtnOkClicked(View view) {
        Intent returnIntent = new Intent(EditProfileActivity.this, ProfileActivity.class);

        returnIntent.putExtra(ProfileActivity.EXTRA_NAME, et_name.getText().toString());
        returnIntent.putExtra(ProfileActivity.EXTRA_EMAIL, et_email.getText().toString());
        returnIntent.putExtra(ProfileActivity.EXTRA_PHONE_NUMBER, et_phone_number.getText().toString());

        setResult(Activity.RESULT_OK, returnIntent);

        finish();
    }

    public void onBtnCancelClicked(View view) {
        Intent returnIntent = new Intent(EditProfileActivity.this, ProfileActivity.class);

        setResult(Activity.RESULT_CANCELED, returnIntent);

        finish();
    }

    private void init() {
        et_name = findViewById(R.id.et_username);
        et_email = findViewById(R.id.et_user_email);
        et_phone_number = findViewById(R.id.et_user_phone_number);
    }

}
