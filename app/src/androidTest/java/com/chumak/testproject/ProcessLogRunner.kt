package com.chumak.testproject

import android.app.Instrumentation
import android.os.Bundle
import android.os.Process
import androidx.test.runner.AndroidJUnitRunner
import kotlin.concurrent.thread

/**
 *
 *
 * @author Evgeny Chumak
 **/
class ProcessLogRunner : AndroidJUnitRunner() {

    override fun onCreate(arguments: Bundle?) {
        super.onCreate(arguments)
        println("foo = ${arguments?.get("foo")}")
        println("bar = ${arguments?.get("bar")}")
        println("instrumentationProcess = ${Process.myPid()}")
    }
}