package cn.clp.login.models

class LoginModel {
     var userAccount:String?=null
     var userPassword:String?=null
    override fun toString(): String {
        var loginModel=LoginModel()
        loginModel.javaClass.genericSuperclass

        return "LoginModel(userAccount=$userAccount, userPassword=$userPassword)"
    }


}