package com.challenge.kippo

import android.content.Context
import androidx.test.platform.app.InstrumentationRegistry
import com.challenge.kippo.backend.api.ClientManager
import com.challenge.kippo.backend.api.SessionManager
import org.junit.Before
import org.junit.Test

//TODO umm is this needed?
class SessionManagerTests {
    lateinit var context: Context
    lateinit var sessionManager: SessionManager
    @Before
    fun setUp(){
        context = InstrumentationRegistry.getInstrumentation().targetContext
        sessionManager = SessionManager(context)
    }
    @Test
    fun saveAuthTokenTest(){
        val testToken = "invalid_token"
        sessionManager.saveAuthToken(testToken)
        //Verify it was saved to SharedPreferences
        assert(testToken == sessionManager.fetchAuthToken())
    }
    @Test
    fun fetchAuthTokenTest(){
        val testToken = "new_token"
        sessionManager.saveAuthToken(testToken)
        //Verify it was saved to SharedPreferences
        assert(testToken == sessionManager.fetchAuthToken())

    }
}