package com.chumak.testproject

import org.junit.runner.RunWith
import org.junit.runners.Suite

/**
 *
 *
 * @author Evgeny Chumak
 **/
@RunWith(Suite::class)
@Suite.SuiteClasses(
    value = [
        UITest::class,
        UITest2::class,
    ]
)
class UITestSuite {
}