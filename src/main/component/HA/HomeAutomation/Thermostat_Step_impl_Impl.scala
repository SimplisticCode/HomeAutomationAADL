// #Sireum

package HA.HomeAutomation

import org.sireum._
import HA._

// the contents of this file will not be overwritten
@record class Thermostat_Step_impl_Impl (val api : Thermostat_Step_impl_Bridge.Api) extends Thermostat_Step_impl {

  override def initialise(): Unit = {
    // example api usage

    api.logInfo("Example info logging")
    api.logDebug("Example debug logging")
    api.logError("Example error logging")

    val apiUsage_TermostatCmd: Option[HomeAutomation.TermostatCMD.Type] = api.getTermostatCmd()
    api.sendTermostatAct()
  }

  override def handleTermostatCmd(value : HomeAutomation.TermostatCMD.Type): Unit = {
    api.logInfo(s"received ${value}")
    api.logInfo("example handleTermostatCmd implementation")
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
