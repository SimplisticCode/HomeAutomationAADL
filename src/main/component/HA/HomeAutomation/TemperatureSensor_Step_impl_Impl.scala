// #Sireum

package HA.HomeAutomation

import org.sireum._
import HA._

// the contents of this file will not be overwritten
@record class TemperatureSensor_Step_impl_Impl (val api : TemperatureSensor_Step_impl_Bridge.Api) extends TemperatureSensor_Step_impl {

  override def initialise(): Unit = {
    // example api usage

    api.logInfo("Example info logging")
    api.logDebug("Example debug logging")
    api.logError("Example error logging")

    val apiUsage_Temp_in: Option[HomeAutomation.Temperature] = api.getTemp_in()
    val apiUsage_Temp_out: Option[HomeAutomation.Temperature] = api.getTemp_out()
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
