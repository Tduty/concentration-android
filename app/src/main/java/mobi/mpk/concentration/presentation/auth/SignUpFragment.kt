package mobi.mpk.concentration.presentation.auth

import android.annotation.SuppressLint
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_login.view.*
import kotlinx.android.synthetic.main.fragment_singup.view.*
import mobi.mpk.concentration.R

@SuppressLint("ValidFragment")
class SignUpFragment(private val authPresenter: AuthPresenter) : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_singup, container, false)
        view.text_login.setOnClickListener {authPresenter.openLogin()}
        view.button_singup.setOnClickListener {
            authPresenter.sugnUp(view.edit_email.text.toString(),
                view.edit_password.text.toString(),
                view.edit_confirm_password.text.toString())}
        return view
    }

}