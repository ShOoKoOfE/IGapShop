package com.adeli.igapshop.ui.productList

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.runtime.remember
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.test.platform.app.InstrumentationRegistry
import coil.ImageLoader
import com.adeli.datasource.network.model.Product
import com.adeli.igapshop.Utils.Companion.mockResponseFileReader
import com.adeli.igapshop.coil.FakeImageLoader
import com.adeli.igapshop.ui.components.ProductList
import com.adeli.igapshop.ui.theme.IGapShopTheme
import com.adeli.ui_productlist.ui.ProductListState
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import org.junit.Rule
import org.junit.Test

@ExperimentalAnimationApi
@ExperimentalComposeUiApi
class ProductListTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    private val context = InstrumentationRegistry.getInstrumentation().targetContext
    private val imageLoader: ImageLoader = FakeImageLoader.build(context)
    private val productData: List<Product> = Gson().fromJson(mockResponseFileReader("data/ValidData.json"),object : TypeToken<List<Product>>() {}.type)

    @Test
    fun areProductsShown() {
        composeTestRule.setContent {
            IGapShopTheme() {
                val state = remember {
                    ProductListState(
                        products = productData,
                    )
                }
                ProductList(
                    state = state,
                    imageLoader = imageLoader,
                )
            }
        }
        composeTestRule.onNodeWithText("شامپو مو فابریگاس مدل Pepper حجم 400 میلی لیتر").assertIsDisplayed()
        composeTestRule.onNodeWithText("شامپو مو لورآل سری Mythic Oil مدل Thick Hair").assertIsDisplayed()
        composeTestRule.onNodeWithText("شامپو مو مای مدل کلین فرش حجم 400 میلی لیتر").assertIsDisplayed()
    }
}
