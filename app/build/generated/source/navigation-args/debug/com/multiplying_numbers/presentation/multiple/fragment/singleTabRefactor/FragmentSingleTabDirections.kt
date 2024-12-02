package com.multiplying_numbers.presentation.multiple.fragment.singleTabRefactor

import android.os.Bundle
import androidx.navigation.NavDirections
import com.multiplying_numbers.R
import kotlin.Int

public class FragmentSingleTabDirections private constructor() {
  private data class ActionSingleTabToFragmentHistory(
    public val idTable: Int = 0,
  ) : NavDirections {
    public override val actionId: Int = R.id.action_singleTab_to_fragmentHistory

    public override val arguments: Bundle
      get() {
        val result = Bundle()
        result.putInt("idTable", this.idTable)
        return result
      }
  }

  public companion object {
    public fun actionSingleTabToFragmentHistory(idTable: Int = 0): NavDirections =
        ActionSingleTabToFragmentHistory(idTable)
  }
}
