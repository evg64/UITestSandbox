pipeline {
    agent any
    stages {
        stage('build') {
            steps {
                sh 'echo "Hello world!"'
                sh 'printenv'
                sh 'adb devices'
                sh '$ANDROID_HOME/emulator/emulator -avd Pixel_XL_API_29 &'
                sh 'adb install -r -t /Users/a16709175/StudioProjects/TestProject2/app/build/outputs/apk/debug/app-debug.apk'
                sh 'adb install -r -t /Users/a16709175/StudioProjects/TestProject2/app/build/outputs/apk/androidTest/debug/app-debug-androidTest.apk'
                sh 'adb shell am instrument -w -m -e debug false -e class \'com.chumak.testproject.UITest\' com.chumak.testproject.test/com.chumak.testproject.ProcessLogRunner'
            }
        }
    }
}