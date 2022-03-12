package com.adeli.igapshop.ui.endToEnd

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.test.platform.app.InstrumentationRegistry
import coil.ImageLoader
import com.adeli.igapshop.coil.FakeImageLoader
import com.adeli.igapshop.ui.MainActivity
import com.adeli.igapshop.ui.components.Login
import com.adeli.igapshop.ui.components.ProductList
import com.adeli.igapshop.ui.navigation.Screen
import com.adeli.igapshop.ui.theme.IGapShopTheme
import com.adeli.ui_login.ui.LoginViewModel
import com.adeli.ui_productlist.ui.ProductListViewModel
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import org.junit.Before
import org.junit.Rule
import org.junit.Test

/**
 * NOTE: These tests will fail with Accompanist Animations for navigation transitions.
 * To get them to pass you can't use 'import com.google.accompanist.navigation.animation.composable'
 *
 * End to end tests for the ProductList Screen.
 * Basically I tested all the things a user could do in this screen.
 */

@ExperimentalAnimationApi
@ExperimentalComposeUiApi
@HiltAndroidTest
class LoginEndToEnd {
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
                            route = Screen.ProductList.route,
                            arguments = Screen.Login.arguments,
                        ){
                            val viewModel: ProductListViewModel = hiltViewModel()
                            ProductList(
                                state = viewModel.state.value,
                                imageLoader = imageLoader,
                                navController = navController
                            )
                        }
                        composable(
                            route = Screen.Login.route,
                            arguments = Screen.Login.arguments,
                        ){
                            val viewModel: LoginViewModel = hiltViewModel()
                            Login(
                                state = viewModel.state.value,
                                viewModel = viewModel,
                                navController = navController
                            )
                        }
                    }
                )
            }
        }
    }

    @Test
    fun testLogin(){
        composeTestRule.onNodeWithText("Login").performClick()
        composeTestRule.onNodeWithText("email").assertIsDisplayed()
        composeTestRule.onNodeWithText("password").assertIsDisplayed()
    }
}
