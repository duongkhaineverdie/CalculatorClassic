package com.dkneverd.calculatorclassic.utils

import androidx.appcompat.app.AppCompatDelegate
import kotlinx.datetime.Instant
import kotlinx.datetime.format
import java.text.SimpleDateFormat
import java.time.format.DateTimeFormatter
import java.util.Date
import java.util.Locale

object Graphs {
    const val ROOT = "root_graph"
    const val HOME = "home_graph"
}

object Destinations {
    const val ONBOARDING = "onboarding"
    const val TASKS = "tasks"
    const val CALENDAR = "calendar"
    const val ADD_EDIT = "addEdit/{taskId}"
    const val SETTINGS = "settings"
    const val TASK = "task/{taskId}"
}

object NavArguments {
    const val TASK_ID = "taskId"
}

object DataStore {
    const val NAME = "UpTodo"
    const val IS_ONBOARDING_COMPLETED_KEY = "isOnboardingCompletedKey"
    const val IS_ONBOARDING_COMPLETED_DEFAULT = false
    const val THEME_MODE_KEY = "themeModeKey"
    const val THEME_MODE_DEFAULT = AppCompatDelegate.MODE_NIGHT_FOLLOW_SYSTEM
}

object Database {
    const val NAME = "UpTodo.db"
    const val TABLE_TASKS = "tasks"
}

object Constants {
    fun convertMillisToFormattedDate(timestamp: Long): String {
        val formatter = SimpleDateFormat("dd-MM-yyyy hh:mm aaa", Locale.US)
        val date = Date(timestamp)
        return formatter.format(date)
    }
}