package apps.robot.homework_1

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_details.*

class DetailsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)
        init()
    }

    private fun init() {
        tv_user_name.text = intent.extras.getString(MainActivity.USER_NAME)
        tv_user_interests.text = intent.extras.getString(MainActivity.USER_INTERESTS)
        iv_user_photo.setImageResource(intent.extras.getInt(MainActivity.USER_PHOTO))
    }
}
