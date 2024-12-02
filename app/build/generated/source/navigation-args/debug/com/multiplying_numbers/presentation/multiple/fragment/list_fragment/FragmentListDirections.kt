package com.multiplying_numbers.presentation.multiple.fragment.list_fragment

import android.os.Bundle
import androidx.navigation.NavDirections
import com.multiplying_numbers.R
import kotlin.Int

public class FragmentListDirections private constructor() {
  private data class ActionListFragmentToSingleTab(
    public val idTable: Int = -1,
  ) : NavDirections {
    public override val actionId: Int = R.id.action_listFragment_to_singleTab

    public override val arguments: Bundle
      get() {
        val result = Bundle()
        result.putInt("idTable", this.idTable)
        return result
      }
  }

  public companion object {
    public fun actionListFragmentToSingleTab(idTable: Int = -1): NavDirections =
        ActionListFragmentToSingleTab(idTable)
  }
}
