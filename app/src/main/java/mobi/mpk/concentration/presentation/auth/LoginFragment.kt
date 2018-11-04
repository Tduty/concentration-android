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
class LoginFragment(private val authPresenter: AuthPresenter) : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_login, container, false)
        view.text_singup_button.setOnClickListener {authPresenter.openSingUp()}
        view.button_singin.setOnClickListener {authPresenter.login(view.edit_login_email.text.toString(), view.edit_login_password.text.toString())}
        return view
    }

}