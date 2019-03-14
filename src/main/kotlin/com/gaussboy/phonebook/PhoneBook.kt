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

class PhoneBook() {

    val phones = mutableListOf<MutableSet<String>>()
    val names = mutableListOf<String>()

    fun addNewName(name: String) {
        if (!Regex("""([А-Яа-яA-Za-zЁё]+( )?)+""").matches(name)) throw IllegalArgumentException()
        names.add(name)
        phones.add(mutableSetOf())
    }

    fun addNewName(name: String, phone: String) {
        if (!Regex("""([0-9]|[-+*#])+""").matches(phone)) throw IllegalArgumentException()
        addNewName(name)
        phones[names.indexOf(name)].add(phone)
    }

    fun addNewPhone(name: String, phone: String) {
        if (!Regex("""([0-9]|[-+*#])+""").matches(phone)) throw IllegalArgumentException()
        if (name in names)
            phones[names.indexOf(name)].add(phone)
        else
            addNewPhone(name, phone)
    }


    fun deleteName(name: String) {
        if (!Regex("""([А-Яа-яA-Za-zЁё]+( )?)+""").matches(name)) throw IllegalArgumentException()
        if (name in names) {
            phones.removeAt(names.indexOf(name))
            names.removeAt(names.indexOf(name))
        }

    }

    fun deletePhone(name: String, phone: String) {
        if (!Regex("""([А-Яа-яA-Za-zЁё]+( )?)+""").matches(name)) throw IllegalArgumentException()
        if (!Regex("""([0-9]|[-+*#])+""").matches(phone)) throw IllegalArgumentException()
        if (name in names) {
            if (phone in phones[names.indexOf(name)])
                phones[names.indexOf(name)].remove(phone)
            else println("У данного пользователя нет такого телефона.")
        }
        else println("Нет такого пользователя.")
    }

    fun searchByPhone(phone: String): String {
        for (i in phones) {
            if (phone in i) return names[phones.indexOf(i)]
        }
        return "Пользователя с таким номером не существует."
    }

    //Если пользователя не существует, возвращается пустой лист
    fun searchByName(name: String): Set<String> {
        if (name in names) return phones[names.indexOf(name)]
        return setOf()
    }

    override fun toString(): String {
        val bldr = StringBuilder()
        for (i in names)
            bldr.append(i).append(" - ").append(phones[names.indexOf(i)]).append("\n")
        return bldr.toString()
    }
}
