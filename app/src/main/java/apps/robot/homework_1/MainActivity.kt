package apps.robot.homework_1

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), UsersListClickListener {
    private var mUsersList: ArrayList<User> = getData()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        init()
    }

    override fun onClick(pos: Int) {
        val intent = Intent(this, DetailsActivity::class.java)

        intent.putExtra(USER_NAME, mUsersList[pos].name)
        intent.putExtra(USER_INTERESTS, mUsersList[pos].interests)
        intent.putExtra(USER_PHOTO, mUsersList[pos].photo)

        startActivity(intent)
    }

    private fun init() {
        mUsersList = getData()
        val adapter = UserAdapter(this, mUsersList, this)

        rv_users.layoutManager = LinearLayoutManager(this)
        rv_users.adapter = adapter
    }

    companion object {
        const val USER_NAME: String = "USER_NAME"
        const val USER_INTERESTS: String = "USER_INTERESTS"
        const val USER_PHOTO: String = "USER_PHOTO"
    }
}
