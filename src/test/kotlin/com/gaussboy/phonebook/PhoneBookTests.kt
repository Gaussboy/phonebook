package com.gaussboy.phonebook

import org.junit.Assert.assertEquals
import org.junit.Test


class PhoneBookTests {
    @Test
    fun addNewNameTest() {
        val book = PhoneBook()
        book.addNewName("Ступин Алексей Глебович")
        assertEquals("Ступин Алексей Глебович - [[]]\n", book.toString())
    }
    @Test
    fun addNewNameTest2() {
        val book = PhoneBook()
        book.addNewName("Ступин Алексей Глебович", "+79992410359")
        assertEquals("Ступин Алексей Глебович - [[+79992410359]]\n", book.toString())
    }
    @Test
    fun addNewPhoneTest() {
        val book = PhoneBook()
        book.addNewPhone("Ступин Алексей Глебович", "+79992410359")
        assertEquals("Ступин Алексей Глебович - [[+79992410359]]\n", book.toString())
    }
    @Test
    fun deleteNameTest() {
        val book = PhoneBook()
        book.addNewName("Ступин Алексей Глебович", "+79992410359")
        assertEquals("Ступин Алексей Глебович - [[+79992410359]]\n", book.toString())
        book.deleteName("Ступин Алексей Глебович")
        assertEquals("", book.toString())
    }
    @Test
    fun deletePhoneTest() {
        val book = PhoneBook()
        book.addNewName("Ступин Алексей Глебович", "+79992410359")
        assertEquals("Ступин Алексей Глебович - [[+79992410359]]\n", book.toString())
        book.deletePhone("Ступин Алексей Глебович", "+79992410359")
        assertEquals("Ступин Алексей Глебович - [[]]\n", book.toString())
    }
    @Test
    fun searchByNameTest() {
        val book = PhoneBook()
        assertEquals(setOf<String>(), book.searchByName("Ступин Алексей Глебович"))
    }
    @Test
    fun searchByPhoneTest() {
        val book = PhoneBook()
        assertEquals("Пользователя с таким номером не существует.",
            book.searchByPhone("+79992410359"))
    }
}
