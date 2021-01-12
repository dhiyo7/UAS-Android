package yayang.setiyawan.uasmobile.utilities

import android.content.Context

class Utils {
    companion object {
        var API_ENDPOINT = "https://088ca8293495.ngrok.io/"


        fun getToken(context: Context) : String? {
            val token = context.getSharedPreferences("USER", Context.MODE_PRIVATE)
            return token?.getString("TOKEN", null)
        }

        fun setToken(context : Context, token: String) {
            val pref = context.getSharedPreferences("USER", Context.MODE_PRIVATE)
            pref.edit().apply(){
                putString("TOKEN", token)
                apply()
            }
        }

        fun clearToken(context: Context){
            val pref = context.getSharedPreferences("USER", Context.MODE_PRIVATE)
            pref.edit().clear().apply()
        }

        fun isValidPassword(password : String) = password.length > 6

    }
}