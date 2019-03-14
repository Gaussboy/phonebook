package com.gaussboy.phonebook

import org.junit.Assert.assertEquals
import org.junit.Test

class PhoneBookTests {
    @Test
    fun addNewNameTest() {
        val book = PhoneBook()
        book.addNewName("Ступин Алексей Глебович")
        assertEquals("Ступин Алексей Глебович - []\n", book.toString())
    }
    @Test
    fun addNewNameTest2() {
        val book = PhoneBook()
        book.addNewName("Лоховской Пётр Конченович", "+79992410359")
        assertEquals("Лоховской Пётр Конченович - [+79992410359]\n", book.toString())
    }
    @Test
    fun addNewPhoneTest() {
        val book = PhoneBook()
        book.addNewPhone("Лоховской Пётр Конченович", "+79992410359")
        assertEquals("Лоховской Пётр Конченович - [+79992410359]\n", book.toString())
    }
    @Test
    fun deleteNameTest() {
        val book = PhoneBook()
        book.deleteName("Лоховской Пётр Конченович")
        assertEquals("", book.toString())
    }
    @Test
    fun deletePhoneTest() {
        val book = PhoneBook()
        book.deletePhone("Лоховской Пётр Конченович", "+79992410359")
        assertEquals("", book.toString())
    }
    @Test
    fun searchByNameTest() {
        val book = PhoneBook()
        book.searchByName("Лоховской Пётр Конченович")
        assertEquals("", book.toString())
    }
    @Test
    fun searchByPhoneTest() {
        val book = PhoneBook()
        book.searchByPhone("+79992410359")
        assertEquals("", book.toString())
    }
}