// #Sireum

package HA.HomeAutomation

import org.sireum._
import HA._

// the contents of this file will not be overwritten
@record class HumidSensor_Step_impl_Impl (val api : HumidSensor_Step_impl_Bridge.Api) extends HumidSensor_Step_impl {

  override def initialise(): Unit = {
    // example api usage

    api.logInfo("Example info logging")
    api.logDebug("Example debug logging")
    api.logError("Example error logging")

    api.sendHumid_out(HomeAutomation.Humidity.empty())
    val apiUsage_Humid_in: Option[HomeAutomation.Humidity] = api.getHumid_in()
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
