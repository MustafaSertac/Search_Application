package com.example.testapplication.view

import androidx.navigation.NavController
import androidx.navigation.Navigation

import androidx.test.espresso.Espresso
import androidx.test.espresso.ViewAction
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.filters.MediumTest
import com.example.testapplication.R
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import kotlinx.coroutines.ExperimentalCoroutinesApi

import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.mockito.Mockito
import javax.inject.Inject

@MediumTest
@HiltAndroidTest
@ExperimentalCoroutinesApi
class ArtFragmentTest {
@Inject
    lateinit var fragmentFactory: ArtFragmentFactory
    @get:Rule
    var hiltRule = HiltAndroidRule(this)
@Before
fun setup(){
    hiltRule.inject()
}
    @Test
    fun testNavigationFromArtToDetail(){
val navController=Mockito.mock(NavController::class.java)
launchFragmentInHiltContainer<ArtFragment>(factory =fragmentFactory ){

Navigation.setViewNavController(requireView(),navController)
}
Espresso.onView(ViewMatchers.withId(R.id.fab)).perform(ViewActions.click())
        Mockito.verify(navController).navigate(ArtFragmentDirections.actionArtFragmentToArtDetailsFragment())
    }


}
