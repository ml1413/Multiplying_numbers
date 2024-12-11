# Add project specific ProGuard rules here.
# You can control the set of applied configuration files using the
# proguardFiles setting in build.gradle.
#
# For more details, see
#   http://developer.android.com/guide/developing/tools/proguard.html

# If your project uses WebView with JS, uncomment the following
# and specify the fully qualified class name to the JavaScript interface
# class:
#-keepclassmembers class fqcn.of.javascript.interface.for.webview {
#   public *;
#}

# Uncomment this to preserve the line number information for
# debugging stack traces.
#-keepattributes SourceFile,LineNumberTable

# If you keep the line number information, uncomment this to
# hide the original source file name.
#-renamesourcefileattribute SourceFile
# Сохранить класс TypeTable
-keep class com.multiplying_numbers.domain.TypeTable { *; }



# Сохранение аннотации @Parcelize
-keep class kotlinx.parcelize.Parcelize

# Сохранение всех классов с аннотацией @Parcelize
-keep @kotlinx.parcelize.Parcelize class * { *; }


# Сохранение атрибутов для работы с дженериками
-keepattributes Signature
-keepattributes *Annotation*

# Сохранение классов TypeToken и их анонимных подклассов
-keep class com.google.gson.reflect.TypeToken { *; }
-keep class * extends com.google.gson.reflect.TypeToken

-keep class com.google.gson.** { *; }
-keep class com.multiplying_numbers.data.storage.sharedPref.ModelHistoryStorage { *; }
-keep class com.multiplying_numbers.data.storage.sharedPref.ItemHistoryStorage { *; }
-keep class com.multiplying_numbers.data.storage.sharedPref.ModelQuestionsStorage { *; }
-keep class com.multiplying_numbers.data.storage.sharedPref.ColorCountWrongAnswerStorage { *; }
-keep class com.multiplying_numbers.data.storage.sharedPref.ColorQuestionStorage { *; }
