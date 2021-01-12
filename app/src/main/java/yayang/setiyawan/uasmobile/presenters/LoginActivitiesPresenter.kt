package yayang.setiyawan.uasmobile.presenters

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import yayang.setiyawan.uasmobile.contracts.LoginActivitiesContract
import yayang.setiyawan.uasmobile.models.User
import yayang.setiyawan.uasmobile.utilities.Utils
import yayang.setiyawan.uasmobile.webservice.Api
import yayang.setiyawan.uasmobile.webservice.WrappedResponse

class LoginActivitiesPresenter(v : LoginActivitiesContract.View?): LoginActivitiesContract.Interaction {
    private var view : LoginActivitiesContract.View? = v
    private var api = Api.instance()
    override fun validate(id: String, password: String): Boolean {
    view?.passwordError(null)
    if(!Utils.isValidPassword(password)){
        view?.passwordError("Password tidak valid")
        return false
    }
    return true
}

    override fun login(email: String, password: String) {
        view?.isLoading(true)
        api.login(email, password).enqueue(object : Callback<WrappedResponse<User>> {
            override fun onFailure(call: Call<WrappedResponse<User>>, t: Throwable) {
                view?.toast("koneksi ke server tidak bisa")
                println("asunemen "+ t.message)
                view?.notConect()
            }

            override fun onResponse(call: Call<WrappedResponse<User>>, response: Response<WrappedResponse<User>>) {
                if (response.isSuccessful){
                    val body = response.body()
                    if (body != null && body.status){
                        view?.success(body.data?.token!!)
                    }else {
                        view?.toast("Login Gagal, cek email dan password")
                    }
                }else {
                    view?.toast("Ada yang tidak beres, coba lagi nanti, atau hungungi admin")
                }
                view?.isLoading(false)
            }

        })
    }

    override fun destroy() {
    view = null
    }

}