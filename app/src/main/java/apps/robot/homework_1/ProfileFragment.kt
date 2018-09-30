package apps.robot.homework_1

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView

class ProfileFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val rootView = inflater.inflate(R.layout.fragment_profile, container, false)
        val btnEdit = rootView!!.findViewById<Button>(R.id.btn_edit)
        btnEdit.setOnClickListener {
            val ft = fragmentManager

            val editDialogFragment = EditDialogFragment.newInstance(getString(R.string.title_edit_dialog))

            editDialogFragment.show(ft, editDialogFragment.toString())

        }
        return rootView
    }

    fun updateLoginEmail(login: String, email: String) {
        val tvLogin = view!!.findViewById<TextView>(R.id.tv_user_login)
        val tvEmail = view!!.findViewById<TextView>(R.id.tv_user_email)

        tvLogin.text = login
        tvEmail.text = email
    }


    companion object {
        @JvmStatic
        fun newInstance() = ProfileFragment()
    }
}
