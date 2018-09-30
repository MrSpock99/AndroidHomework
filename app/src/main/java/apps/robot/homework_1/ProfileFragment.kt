package apps.robot.homework_1

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_profile.*
import kotlinx.android.synthetic.main.fragment_profile.view.*

class ProfileFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val rootView = inflater.inflate(R.layout.fragment_profile, container, false)
        rootView.btn_edit.setOnClickListener {
            val ft = fragmentManager

            val editDialogFragment = EditDialogFragment.newInstance(getString(R.string.title_edit_dialog))

            editDialogFragment.show(ft, editDialogFragment.toString())

        }
        return rootView
    }

    fun updateLoginEmail(login: String, email: String) {
        tv_user_login.text = login
        tv_user_email.text = email
    }

    companion object {
        fun newInstance() = ProfileFragment()
    }
}
