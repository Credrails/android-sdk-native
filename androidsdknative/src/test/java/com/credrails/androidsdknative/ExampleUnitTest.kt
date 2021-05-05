package com.credrails.androidsdknative

import com.credrails.androidsdknative.models.SessionsParameter
import org.junit.Test

import org.junit.Assert.*

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {

    @Test
    fun canCreate_Session() {

        // create
        val params  =
        SessionsParameter.Builder()
                     .setEmail("johndoe@example.com")
                     .setName("John Doe")
                     .setUserReference("john-doe-12345")
                     .Build();

        val manager = SessionsManager();
        val res = manager.createSession(params);


        assertEquals(4, 2 + 2)
    }
}