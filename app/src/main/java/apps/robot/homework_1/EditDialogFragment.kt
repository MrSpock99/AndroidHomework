package apps.robot.homework_1

import android.app.AlertDialog
import android.app.Dialog
import android.content.Context
import android.os.Bundle
import android.support.v4.app.DialogFragment
import android.widget.EditText


private const val ARG_TITLE = "ARG_TITLE"

class EditDialogFragment : DialogFragment() {
    private var listener: OnEditedListener? = null

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val alertDialogBuilder = AlertDialog.Builder(context)
        val rootView = activity!!.layoutInflater.inflate(R.layout.fragment_edit_dialog, null)
        alertDialogBuilder
                .setView(rootView)
                .setTitle(arguments?.getString(ARG_TITLE))
                .setPositiveButton(getString(R.string.ok)) { dialog, which ->
                    val login = rootView.findViewById<EditText>(R.id.et_login).text.toString()
                    val email = rootView.findViewById<EditText>(R.id.et_email).text.toString()
                    listener!!.onEdit(login, email)
                }
                .setNegativeButton(getString(R.string.cancel)) { dialog, which ->
                    dialog.dismiss()
                }


        return alertDialogBuilder.create()
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is OnEditedListener) {
            listener = context
        } else {
            throw RuntimeException(context.toString() + " must implement OnFragmentInteractionListener")
        }
    }

    override fun onDetach() {
        super.onDetach()
        listener = null
    }

    interface OnEditedListener {
        fun onEdit(login: String, email: String)
    }

    companion object {
        @JvmStatic
        fun newInstance(title: String) =
                EditDialogFragment().apply {
                    arguments = Bundle().apply {
                        putString(ARG_TITLE, title)
                    }
                }
    }
}
