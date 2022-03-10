object Retrofit {
    private const val retrofitVersion = "2.9.0"
    private const val okHttpVersion = "4.9.0"
    const val retrofit =  "com.squareup.retrofit2:retrofit:$retrofitVersion"
    const val retrofitConverter = "com.squareup.retrofit2:converter-gson:$retrofitVersion"
    const val okHttp = "com.squareup.okhttp3:okhttp:$okHttpVersion"
    const val httpLoggingInterceptor =  "com.squareup.okhttp3:logging-interceptor:$okHttpVersion"
}
object RetrofitTest {
    private const val muckVersion = "4.3.0"
    const val mockWebServer =  "com.squareup.okhttp3:mockwebserver:$muckVersion"
}