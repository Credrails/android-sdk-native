package com.credrails.androidsdknative

import com.credrails.androidsdknative.models.SessionsParameter
import org.junit.Test

import org.junit.Assert.*

class SessionsTests {

    @Test
    fun canCreate_Session() {

        // Arrange
        val params  =
        SessionsParameter.Builder()
                     .setEmail("johndoe@example.com")
                     .setName("John Doe")
                     .setUserReference("john-doe-12345")
                     .Build();

        val manager = SessionsManager();

        // Act
        val res = manager.createSession(params);

        // Assert
        assertTrue(res.contains("session_id"));
    }
}