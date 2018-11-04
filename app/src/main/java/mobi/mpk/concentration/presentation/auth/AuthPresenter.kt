package mobi.mpk.concentration.presentation.auth

import android.view.View
import mobi.mpk.concentration.domain.AuthInteractor

class AuthPresenter(private val authInteractor: AuthInteractor, private val authRouter: AuthRouter) {

    lateinit var view: View

    fun openSingUp() {
        authRouter.openSignUp()
    }

    fun openLogin() {
        authRouter.openLogin()
    }

    fun login(email: String, password: String) {
        authRouter.openMain()
    }

    fun sugnUp(email: String, password: String, confirmPassword: String) {
        authRouter.openMain()
    }

}