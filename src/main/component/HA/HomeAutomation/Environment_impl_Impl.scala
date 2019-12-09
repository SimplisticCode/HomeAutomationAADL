// #Sireum

package HA.HomeAutomation

import org.sireum._
import HA._

// the contents of this file will not be overwritten
@record class Environment_impl_Impl (val api : Environment_impl_Bridge.Api) extends Environment_impl {

  override def initialise(): Unit = {
    // example api usage

    api.logInfo("Example info logging")
    api.logDebug("Example debug logging")
    api.logError("Example error logging")

  }


  override def activate(): Unit = {
    // example override of activate
  }

  override def deactivate(): Unit = {
    // example override of deactivate
  }

  override def finalise(): Unit = {
    // example override of finalise
  }

  override def recover(): Unit = {
    // example override of recover
  }
}
