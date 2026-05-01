package com.nmp.habittrackeranmp.view

import androidx.navigation.ActionOnlyNavDirections
import androidx.navigation.NavDirections
import com.nmp.habittrackeranmp.R

public class LoginFragmentDirections private constructor() {
  public companion object {
    public fun actionLoginFragmentToDashboardFragment(): NavDirections =
        ActionOnlyNavDirections(R.id.action_loginFragment_to_dashboardFragment)
  }
}
