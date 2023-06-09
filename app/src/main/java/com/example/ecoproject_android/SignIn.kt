package com.example.ecoproject_android

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.kakao.sdk.auth.model.OAuthToken
import com.kakao.sdk.common.model.AuthErrorCause
import com.kakao.sdk.user.UserApiClient
import com.navercorp.nid.NaverIdLoginSDK
import com.navercorp.nid.oauth.NidOAuthLogin
import com.navercorp.nid.oauth.OAuthLoginCallback
import com.navercorp.nid.profile.NidProfileCallback
import com.navercorp.nid.profile.data.NidProfileResponse



class SignIn : AppCompatActivity() {

    private val TAG = this.javaClass.simpleName
    private var email: String = ""
    private var nick: String = ""
    private var name: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_in)


        //val keyHash = Utility.getKeyHash(this)
        //Log.d("Hash", keyHash)

        lateinit var auth: FirebaseAuth

        val naverbtn = findViewById<Button>(R.id.naverlogin)
        val userId = findViewById<EditText>(R.id.userId)
        val password = findViewById<EditText>(R.id.password)
        val loginbutton = findViewById<Button>(R.id.loginbutton)
        val signup = findViewById<TextView>(R.id.signup)
        val kakaologin = findViewById<Button>(R.id.kakaologin)
        val googlelogin = findViewById<Button>(R.id.googlelogin)

        auth = FirebaseAuth.getInstance()
        loginbutton.setOnClickListener {
            val email = userId.text.toString()
            val password = password.text.toString()

            auth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener { task ->
                    if (task.isSuccessful) {
                        Toast.makeText(this, "로그인에 성공했습니다!", Toast.LENGTH_SHORT).show()
                        val intent = Intent(this, MainActivity::class.java)
                        startActivity(intent)
                    } else {
                        Toast.makeText(this, "로그인에 실패했습니다.", Toast.LENGTH_SHORT).show()
                    }
                }
            auth.run { }
        }

        //네이버 로그인 부분
        naverbtn.setOnClickListener {
            val oAuthLoginCallback = object : OAuthLoginCallback {
                override fun onSuccess() {
                    // 네이버 로그인 API 호출 성공 시 유저 정보를 가져온다
                    NidOAuthLogin().callProfileApi(object : NidProfileCallback<NidProfileResponse> {
                        override fun onSuccess(result: NidProfileResponse) {
                            name = result.profile?.name.toString()
                            email = result.profile?.email.toString()
                            nick = result.profile?.nickname.toString()
                            Log.e(TAG, "네이버 로그인한 유저 정보 - 이름 : $name")
                            Log.e(TAG, "네이버 로그인한 유저 정보 - 이메일 : $email")
                            Log.e(TAG, "네이버 로그인한 유저 정보 - 닉네임 : $nick")
                        }

                        override fun onError(errorCode: Int, message: String) {
                            //
                        }

                        override fun onFailure(httpStatus: Int, message: String) {
                            //
                        }
                    })
                }

                override fun onError(errorCode: Int, message: String) {
                    val naverAccessToken = NaverIdLoginSDK.getAccessToken()
                    Log.e(TAG, "naverAccessToken : $naverAccessToken")
                }

                override fun onFailure(httpStatus: Int, message: String) {
                    //
                }
            }

            NaverIdLoginSDK.initialize(
                this@SignIn,
                getString(R.string.naver_client_id),
                getString(R.string.naver_client_secret),
                "앱 이름"
            )
            NaverIdLoginSDK.authenticate(this@SignIn, oAuthLoginCallback)
        }//네이버 로그인


        signup.setOnClickListener {
            val intent = Intent(this, SignUp::class.java)
            startActivity(intent)
        }
        //카카오 로그인
        val callback: (OAuthToken?, Throwable?) -> Unit = { token, error ->
            if (error != null) {
                when {
                    error.toString() == AuthErrorCause.AccessDenied.toString() -> {
                        Toast.makeText(this, "접근이 거부 됨(동의 취소)", Toast.LENGTH_SHORT).show()
                    }
                    error.toString() == AuthErrorCause.InvalidClient.toString() -> {
                        Toast.makeText(this, "유효하지 않은 앱", Toast.LENGTH_SHORT).show()
                    }
                    error.toString() == AuthErrorCause.InvalidGrant.toString() -> {
                        Toast.makeText(this, "인증 수단이 유효하지 않아 인증할 수 없는 상태", Toast.LENGTH_SHORT).show()
                    }
                    error.toString() == AuthErrorCause.InvalidRequest.toString() -> {
                        Toast.makeText(this, "요청 파라미터 오류", Toast.LENGTH_SHORT).show()
                    }
                    error.toString() == AuthErrorCause.InvalidScope.toString() -> {
                        Toast.makeText(this, "유효하지 않은 scope ID", Toast.LENGTH_SHORT).show()
                    }
                    error.toString() == AuthErrorCause.Misconfigured.toString() -> {
                        Toast.makeText(this, "설정이 올바르지 않음(android key hash)", Toast.LENGTH_SHORT).show()
                    }
                    error.toString() == AuthErrorCause.ServerError.toString() -> {
                        Toast.makeText(this, "서버 내부 에러", Toast.LENGTH_SHORT).show()
                    }
                    error.toString() == AuthErrorCause.Unauthorized.toString() -> {
                        Toast.makeText(this, "앱이 요청 권한이 없음", Toast.LENGTH_SHORT).show()
                    }
                }
            }
            else if (token != null) {
                Toast.makeText(this, "로그인에 성공하였습니다.", Toast.LENGTH_SHORT).show()
                val intent = Intent(this, SignIn::class.java)
                startActivity(intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP))
                finish()
            }
        }

        kakaologin.setOnClickListener {
            if(UserApiClient.instance.isKakaoTalkLoginAvailable(this)){
                UserApiClient.instance.loginWithKakaoTalk(this, callback = callback)
            }else{
                UserApiClient.instance.loginWithKakaoAccount(this, callback = callback)
            }
        }


    }
}
