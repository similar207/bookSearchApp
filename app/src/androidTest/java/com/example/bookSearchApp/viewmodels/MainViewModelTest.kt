package com.example.bookSearchApp.viewmodels

import com.example.bookSearchApp.domain.usecase.UserUseCase
import com.example.bookSearchApp.ui.MainViewModel
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import junit.framework.Assert.assertTrue
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.rules.RuleChain
import javax.inject.Inject

@HiltAndroidTest
class MainViewModelTest {

    private lateinit var viewModel: MainViewModel
    private val hiltRule = HiltAndroidRule(this)

    @get:Rule
    val rule: RuleChain = RuleChain
        .outerRule(hiltRule)

    @Inject
    lateinit var userUseCase: UserUseCase

    @Before
    fun setUp() {
        hiltRule.inject()

        viewModel = MainViewModel(userUseCase)
    }

    @Test
    fun testDefaultValues() {
        assertTrue(viewModel.userList.value.isEmpty())
    }
}