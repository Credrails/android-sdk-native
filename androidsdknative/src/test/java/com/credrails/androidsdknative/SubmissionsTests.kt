package com.credrails.androidsdknative

import com.credrails.androidsdknative.models.SessionsParameter
import org.junit.Assert
import org.junit.Test

class SubmissionsTests {

    @Test
    fun canGetAllInstitutions() {

        // Arrange
        val manager = SubmissionsManager();

        // Act
        val res = manager.institutions;


        assert(res[0].id == 0);
    }

    @Test
    fun canGetCountryInstitutions() {

        // Arrange
        val manager = SubmissionsManager();

        // Act
        val res = manager.getInstitutions("ke");


        assert(res[0].id == 5);
    }
}