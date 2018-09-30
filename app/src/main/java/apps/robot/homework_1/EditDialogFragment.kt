package apps.robot.homework_1

import android.app.AlertDialog
import android.app.Dialog
import android.content.Context
import android.os.Bundle
import android.support.v4.app.DialogFragment
import kotlinx.android.synthetic.main.fragment_edit_dialog.*

class EditDialogFragment : DialogFragment() {
    private var mListener: OnEditedListener? = null

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is OnEditedListener) {
            mListener = context
        } else {
            throw RuntimeException(context.toString() + " must implement OnFragmentInteractionListener")
        }
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val alertDialogBuilder = AlertDialog.Builder(context)
        alertDialogBuilder
                .setView(activity?.layoutInflater?.inflate(R.layout.fragment_edit_dialog, null))
                .setTitle(arguments?.getString(ARG_TITLE))
                .setPositiveButton(getString(R.string.all_ok)) { _, _ ->
                    mListener?.onEdit(et_login?.text.toString(), et_email?.text.toString())
                }
                .setNegativeButton(getString(R.string.all_cancel)) { dialog, _ ->
                    dialog.dismiss()
                }
        return alertDialogBuilder.create()
    }

    override fun onDetach() {
        super.onDetach()
        mListener = null
    }

    interface OnEditedListener {
        fun onEdit(login: String, email: String)
    }

    companion object {
        private const val ARG_TITLE = "ARG_TITLE"

        fun newInstance(title: String) =
                EditDialogFragment().apply {
                    arguments = Bundle().apply {
                        putString(ARG_TITLE, title)
                    }
                }
    }
}
