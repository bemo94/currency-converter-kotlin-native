package com.octo.project

class StringRepository {

    /**
     * Gets String queries
     */
    private fun getStringRepositoryQueries(): StringRepositoryQueries? {
        sqlDriver?.let { driver ->
            val database = SqlDelightDatabase(driver)
            return database.stringRepositoryQueries
        }
        return null
    }

    /**
     * Get Strings database
     */
    fun getStrings(): MutableList<String>? {
        val stringRepositoryQueries = getStringRepositoryQueries()
        stringRepositoryQueries?.let {
            return it.selectAll().executeAsList().toMutableList()
        }
        return arrayListOf()
    }

    /**
     * add string to the database
     */
    fun addString(
        string: String
    ) {
        val stringRepository = getStringRepositoryQueries()
        stringRepository?.insertRow(string)
    }
}