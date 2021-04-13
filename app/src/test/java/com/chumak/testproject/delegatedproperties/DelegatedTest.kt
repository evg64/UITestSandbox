package com.chumak.testproject.delegatedproperties

import org.junit.Test
import kotlin.properties.Delegates

/**
 *
 *
 * @author Evgeny Chumak
 **/
class DelegatedTest {

    class TestObservable {

        @Test
        fun testObservable() {
            Foo().apply {
                println("property = $property")
                property = "bar"
                println("property = $property")
                property = "baz"
                println("property = $property")
                property = "buzz"
                println("property = $property")
            }
        }

        @Test
        fun testVetoable() {
            Foo().apply {
                vetoableProperty = "long value"
                println("vetoableProperty = $vetoableProperty")
                vetoableProperty = "1"
                println("vetoableProperty = $vetoableProperty")
                vetoableProperty = "long value2"
                println("vetoableProperty = $vetoableProperty")
                vetoableProperty = "2"
                println("vetoableProperty = $vetoableProperty")
                vetoableProperty = "long value3"
                println("vetoableProperty = $vetoableProperty")
                vetoableProperty = "3"
                println("vetoableProperty = $vetoableProperty")
            }
        }

        inner class Foo {
            var property: String by Delegates.observable("foo") { p, old, new ->
                println("value of ${p.name} is changed from $old to $new")
            }
            var vetoableProperty: String by Delegates.vetoable("foo") { p, old, new ->
                println("trying to change value of ${p.name} from $old to $new")
                new.length > 3
            }
        }
    }

    class TestMapDelegates {
        @Test
        fun testMapDelegate() {
            mapOf(
                "name" to "John",
                "age" to "25",
                "weight" to "87",
                "gender" to "male",
            ).let{
                Foo(it)
            }
                .also {

                    println("name = ${it.name}")
                    println("age = ${it.age}")
                    println("weight = ${it.weight}")
                    println("gender = ${it.gender}")
                }
        }

        inner class Foo(map: Map<String, String>) {
            val name: String by map
            val age: String by map
            val weight: String by map
            val gender: String by map
        }
    }
}