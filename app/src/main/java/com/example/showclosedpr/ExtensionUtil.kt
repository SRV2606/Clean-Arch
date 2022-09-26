package com.example.showclosedpr

import androidx.activity.ComponentActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import java.time.Instant
import java.time.ZoneId
import java.time.format.DateTimeFormatter
import java.util.*

fun <T> ComponentActivity.collectEvent(flow: Flow<T>, collect: suspend (T) -> Unit): Job {
    return lifecycleScope.launch {
        repeatOnLifecycle(Lifecycle.State.STARTED) {
            flow.onEach(collect).collect()
        }
    }
}

fun <T> Fragment.collectEvent(flow: Flow<T>, collect: suspend (T) -> Unit): Job {
    return lifecycleScope.launch {
        repeatOnLifecycle(Lifecycle.State.STARTED) {
            flow.onEach(collect).collect()
        }
    }
}

fun String.toHumanReadableTime(): String {
    val DATE_TIME_PATTERN = "dd,MMM-yyyy | HH:mm "
    val formatter = DateTimeFormatter
        .ofPattern(DATE_TIME_PATTERN)
        .withLocale(
            Locale.ENGLISH
        )
    return Instant.parse(this).atZone(ZoneId.systemDefault()).format(formatter)
}