package com.gaussboy.phonebook
import java.lang.StringBuilder

/**
 * Вариант 4 — телефонная книга
 * Хранит список людей и номеров их телефонов. У каждого человека может быть более одного номера телефона.
 * Методы:
 * добавление /удаление человека,
 * добавление / удаление телефона для заданного человека,
 * поиск номера(ов) телефона по заданному имени человека,
 * поиск человека по заданному номеру телефона.
 * Телефон задаётся последовательностью символов из цифр, +, *, #, -.
 * */

class PhoneBook {
    private val namesPhones = mutableMapOf<String, MutableSet<String>>()

    fun addNewName(name: String) {
        if (!Regex("""([А-Яа-яA-Za-zЁё]+( )?)+""").matches(name)) throw IllegalArgumentException()
        namesPhones[name] = mutableSetOf()
    }

    fun addNewName(name: String, phone: String) {
        if (!Regex("""([0-9]|[-+*#])+""").matches(phone)) throw IllegalArgumentException()
        namesPhones[name] = mutableSetOf(phone)
    }

    fun addNewPhone(name: String, phone: String) {
        if (!Regex("""([0-9]|[-+*#])+""").matches(phone)) throw IllegalArgumentException()
        if (name in namesPhones)
            namesPhones + (name to phone)
        else
            addNewName(name, phone)
    }


    fun deleteName(name: String) {
        if (!Regex("""([А-Яа-яA-Za-zЁё]+( )?)+""").matches(name)) throw IllegalArgumentException()
        if (name in namesPhones)
            namesPhones.remove(name)
            namesPhones - name
        }

    fun deletePhone(name: String, phone: String) {
        if (!Regex("""([А-Яа-яA-Za-zЁё]+( )?)+""").matches(name)) throw IllegalArgumentException()
        if (!Regex("""([0-9]|[-+*#])+""").matches(phone)) throw IllegalArgumentException()
        if (mutableSetOf(phone) == namesPhones[name]) {
                namesPhones[name] = mutableSetOf()
            } else println("У данного пользователя нет такого телефона.")
        if (name !in namesPhones) println("Нет такого пользователя.")
        }

    fun searchByPhone(phone: String): String {
        for ((i)  in namesPhones) {
        if (namesPhones.keys == mutableSetOf(phone)) return i
        }
        return "Пользователя с таким номером не существует."
    }

    //Если пользователя не существует, возвращается пустой лист
    fun searchByName(name: String): MutableSet<String> {
        if (name in namesPhones) return namesPhones.keys
        return mutableSetOf()
    }

    override fun toString(): String {
        val bldr = StringBuilder()
        for ((i) in namesPhones)
            bldr.append(i).append(" - ").append(namesPhones.values).append("\n")
        return bldr.toString()
    }
}

