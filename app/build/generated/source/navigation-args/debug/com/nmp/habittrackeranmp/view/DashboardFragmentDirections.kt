package com.nmp.habittrackeranmp.view

import androidx.navigation.ActionOnlyNavDirections
import androidx.navigation.NavDirections
import com.nmp.habittrackeranmp.R

public class DashboardFragmentDirections private constructor() {
  public companion object {
    public fun actionDashboardFragmentToNewHabitFragment(): NavDirections =
        ActionOnlyNavDirections(R.id.action_dashboardFragment_to_newHabitFragment)
  }
}
