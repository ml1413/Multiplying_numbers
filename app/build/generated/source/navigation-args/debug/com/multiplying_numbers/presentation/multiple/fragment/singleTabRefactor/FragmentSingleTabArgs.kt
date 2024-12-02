package com.multiplying_numbers.presentation.multiple.fragment.singleTabRefactor

import android.os.Bundle
import androidx.lifecycle.SavedStateHandle
import androidx.navigation.NavArgs
import java.lang.IllegalArgumentException
import kotlin.Int
import kotlin.jvm.JvmStatic

public data class FragmentSingleTabArgs(
  public val idTable: Int = -1,
) : NavArgs {
  public fun toBundle(): Bundle {
    val result = Bundle()
    result.putInt("idTable", this.idTable)
    return result
  }

  public fun toSavedStateHandle(): SavedStateHandle {
    val result = SavedStateHandle()
    result.set("idTable", this.idTable)
    return result
  }

  public companion object {
    @JvmStatic
    public fun fromBundle(bundle: Bundle): FragmentSingleTabArgs {
      bundle.setClassLoader(FragmentSingleTabArgs::class.java.classLoader)
      val __idTable : Int
      if (bundle.containsKey("idTable")) {
        __idTable = bundle.getInt("idTable")
      } else {
        __idTable = -1
      }
      return FragmentSingleTabArgs(__idTable)
    }

    @JvmStatic
    public fun fromSavedStateHandle(savedStateHandle: SavedStateHandle): FragmentSingleTabArgs {
      val __idTable : Int?
      if (savedStateHandle.contains("idTable")) {
        __idTable = savedStateHandle["idTable"]
        if (__idTable == null) {
          throw IllegalArgumentException("Argument \"idTable\" of type integer does not support null values")
        }
      } else {
        __idTable = -1
      }
      return FragmentSingleTabArgs(__idTable)
    }
  }
}
