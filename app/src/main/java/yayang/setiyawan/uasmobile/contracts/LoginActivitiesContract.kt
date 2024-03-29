package yayang.setiyawan.uasmobile.contracts

interface LoginActivitiesContract {
    interface View{
        fun toast(message : String)
        fun success(token : String)
        fun isLoading(state : Boolean)
        fun idError(err : String?)
        fun passwordError(err : String?)
        fun notConect()
    }
    interface Interaction{
        fun validate(id : String, password : String) : Boolean
        fun login(email : String, password : String)
        fun destroy()
    }
}