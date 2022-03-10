package com.adeli.igapshop.ui.endToEnd

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.test.*
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.test.platform.app.InstrumentationRegistry
import coil.ImageLoader
import com.adeli.datasource.BuildConfig
import com.adeli.datasource.network.ProductService
import com.adeli.datasource.network.ProductServiceImpl
import com.adeli.datasource.network.Repository
import com.adeli.datasource.network.di.NetworkModule
import com.adeli.igapshop.Utils.Companion.mockResponseFileReader
import com.adeli.igapshop.coil.FakeImageLoader
import com.adeli.igapshop.ui.MainActivity
import com.adeli.igapshop.ui.components.Login
import com.adeli.igapshop.ui.navigation.Screen
import com.adeli.igapshop.ui.theme.IGapShopTheme
import com.adeli.ui_login.ui.LoginViewModel
import com.adeli.ui_login.ui.test.TAG_Email
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import dagger.hilt.android.testing.UninstallModules
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.net.HttpURLConnection
import javax.inject.Singleton

/*@ExperimentalAnimationApi
@ExperimentalComposeUiApi
@UninstallModules(NetworkModule::class)
@HiltAndroidTest*/
class LoginEndToEnd {

/*    @Module
    @InstallIn(SingletonComponent::class)
    object TestNetworkModule {
        @Provides
        @Singleton
        fun provideHttpLoggingInterceptor(): HttpLoggingInterceptor {
            return HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)
        }

        @Provides
        @Singleton
        fun providesOkHttpClient(
            loggingInterceptor: HttpLoggingInterceptor
        ): OkHttpClient {
            val builder = OkHttpClient.Builder()
            if (BuildConfig.DEBUG) {
                builder.addInterceptor(loggingInterceptor)
            }
            return builder.build()
        }

        @Singleton
        @Provides
        fun provideConverterFactory(): GsonConverterFactory =
            GsonConverterFactory.create()

        @Singleton
        @Provides
        fun provideRetrofit(
            okHttpClient: OkHttpClient,
            gsonConverterFactory: GsonConverterFactory
        ): Retrofit.Builder {
            val mockWebServer = MockWebServer()
            val mockResponse = MockResponse().setResponseCode(HttpURLConnection.HTTP_OK).setBody(
                mockResponseFileReader("data/CustomerData.json")
            )
            mockWebServer.enqueue(mockResponse)
            return Retrofit.Builder()
                .baseUrl(mockWebServer.url("/"))
                .addConverterFactory(GsonConverterFactory.create())
                .client(okHttpClient)
        }

        @Singleton
        @Provides
        fun provideProductService(retrofit: Retrofit): ProductService =
            retrofit.create(ProductService::class.java)

        @Singleton
        @Provides
        fun provideProductServiceImpl(productService: ProductService):ProductServiceImpl=
            ProductServiceImpl(productService)

        @Singleton
        @Provides
        fun provideRepository(productServiceImpl: ProductServiceImpl): Repository =
            Repository(productServiceImpl)
    }

    @get:Rule
    var hiltRule = HiltAndroidRule(this)

    @get:Rule
    val composeTestRule = createAndroidComposeRule<MainActivity>()

    private val context = InstrumentationRegistry.getInstrumentation().targetContext
    private val imageLoader: ImageLoader = FakeImageLoader.build(context)

    @Before
    fun before(){
        composeTestRule.setContent {
            IGapShopTheme{
                val navController = rememberNavController()
                NavHost(
                    navController = navController,
                    startDestination = Screen.ProductList.route,
                    builder = {
                        composable(
                            route = Screen.Login.route,
                            arguments = Screen.Login.arguments,
                        ){
                            val viewModel: LoginViewModel = hiltViewModel()
                            Login(
                                state = viewModel.state.value,
                                viewModel = viewModel
                            )
                        }
                    }
                )
            }
        }
    }*/

   /* @Test
    fun testLogin(){
        composeTestRule.onRoot(useUnmergedTree = true).printToLog("TAG")
        composeTestRule.onNodeWithTag(TAG_Email).performTextInput("")
        composeTestRule.onNodeWithTag(TAG_Email, useUnmergedTree = true).assertTextEquals("")
    }*/
}
