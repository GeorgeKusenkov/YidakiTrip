package com.example.yidakitrip

object Utils {
    fun getResourceIdByName(name: String): Int {
        try {
            val field = R.drawable::class.java.getField(name)
            return field.getInt(null)
        } catch (e: Exception) {
            e.printStackTrace()
        }
        return 0
    }
}