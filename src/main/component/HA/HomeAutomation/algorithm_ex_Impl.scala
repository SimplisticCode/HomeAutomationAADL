// #Sireum

package HA.HomeAutomation

import org.sireum._
import HA._

// the contents of this file will not be overwritten
@record class algorithm_ex_Impl (val api : algorithm_ex_Bridge.Api) extends algorithm_ex {

  override def initialise(): Unit = {
    // example api usage

    api.logInfo("Example info logging")
    api.logDebug("Example debug logging")
    api.logError("Example error logging")

    api.setwindowCMD(HomeAutomation.WinCmd.byOrdinal(0).get)
    val apiUsage_termostatCDM: Option[HomeAutomation.TermostatCMD.Type] = api.gettermostatCDM()
    val apiUsage_Temp: Option[HomeAutomation.Temperature] = api.getTemp()
    val apiUsage_Humid: Option[HomeAutomation.Humidity] = api.getHumid()
  }

  override def timeTriggered(): Unit = {
    // example override of timeTriggered
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
