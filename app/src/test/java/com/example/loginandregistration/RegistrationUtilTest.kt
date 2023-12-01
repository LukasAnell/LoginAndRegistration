package com.example.loginandregistration

import com.google.common.truth.Truth.assertThat
import org.junit.Test

class RegistrationUtilTest {
    // methodName_someCondition_expectedResult

    @Test
    fun validatePassword_emptyPassword_isFalse() {
        val actual = RegistrationUtil.validatePassword("", "")
        // assertThat(actual).isEqual(desiredValue)
        assertThat(actual).isFalse()
    }

    @Test
    fun validatePassword_passwordsDontMatch_isFalse() {
        val actual = RegistrationUtil.validatePassword("password", "password1")
        assertThat(actual).isFalse()
    }

    // Make tests for failures of
    // min length of 8 chars
    @Test
    fun validatePassword_passwordTooShort_isFalse() {
        val actual = RegistrationUtil.validatePassword("pass", "pass")
        assertThat(actual).isFalse()
    }

    // at least one digit   (make sure it's at least 8 and has a capital letter)
    @Test
    fun validatePassword_passwordNoDigits_isFalse() {
        val actual = RegistrationUtil.validatePassword("password", "password")
        assertThat(actual).isFalse()
    }

    // at least one capital letter
    @Test
    fun validatePassword_passwordNoCapitalLetter_isFalse() {
        val actual = RegistrationUtil.validatePassword("password1", "password1")
        assertThat(actual).isFalse()
    }

    // Make a test for good matching passwords working
    @Test
    fun validatePassword_goodPassword_isTrue() {
        val actual = RegistrationUtil.validatePassword("Password1", "Password1")
        assertThat(actual).isTrue()
    }

    // Make the tests for the other functions in the Util class with
    // the common failures and 1 success for each
    @Test
    fun validateUsername_emptyUsername_isFalse() {
        val actual = RegistrationUtil.validateUsername("")
        assertThat(actual).isFalse()
    }

    @Test
    fun validateUsername_usernameTooShort_isFalse() {
        val actual = RegistrationUtil.validateUsername("hi")
        assertThat(actual).isFalse()
    }

    @Test
    fun validateUsername_usernameDoesNotAlreadyExist_isFalse() {
        val actual = RegistrationUtil.validateUsername("user")
        assertThat(actual).isFalse()
    }

    @Test
    fun validateUsername_goodUsername_isTrue() {
        val actual = RegistrationUtil.validateUsername("user1")
        assertThat(actual).isTrue()
    }

    @Test
    fun validateName_emptyName_isFalse() {
        val actual = RegistrationUtil.validateName("")
        assertThat(actual).isFalse()
    }

    @Test
    fun validateName_goodName_isTrue() {
        val actual = RegistrationUtil.validateName("John Doe")
        assertThat(actual).isTrue()
    }

    @Test
    fun validateEmail_emptyEmail_isFalse() {
        val actual = RegistrationUtil.validateEmail("")
        assertThat(actual).isFalse()
    }

    @Test
    fun validateEmail_emailAlreadyExists_isFalse() {
        val actual = RegistrationUtil.validateEmail("user@gmail.com")
        assertThat(actual).isFalse()
    }

    @Test
    fun validateEmail_emailNotInProperFormat_isFalse() {
        val actual = RegistrationUtil.validateEmail("usergmail.com")
        assertThat(actual).isFalse()
    }

    @Test
    fun validateEmail_goodEmail_isTrue() {
        val actual = RegistrationUtil.validateEmail("blah@gmail.com")
        assertThat(actual).isTrue()
    }
}