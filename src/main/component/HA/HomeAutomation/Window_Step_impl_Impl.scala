// #Sireum

package HA.HomeAutomation

import org.sireum._
import HA._

// the contents of this file will not be overwritten
@record class Window_Step_impl_Impl (val api : Window_Step_impl_Bridge.Api) extends Window_Step_impl {

  override def initialise(): Unit = {
    // example api usage

    api.logInfo("Example info logging")
    api.logDebug("Example debug logging")
    api.logError("Example error logging")

    val apiUsage_windowCmd: Option[HomeAutomation.WinCmd.Type] = api.getwindowCmd()
    api.sendwindowAct()
  }

  override def handlewindowCmd(value : HomeAutomation.WinCmd.Type): Unit = {
    api.logInfo(s"received ${value}")
    api.logInfo("example handlewindowCmd implementation")
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
