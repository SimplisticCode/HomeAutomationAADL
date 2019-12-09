// #Sireum

package HA.HomeAutomation

import org.sireum._
import HA._

object Temperature {
  def empty(): HomeAutomation.Temperature = {
    return HomeAutomation.Temperature()
  }
}

@datatype class Temperature() // type skeleton

object Temperature_Payload {
  def empty(): Temperature_Payload = {
    return Temperature_Payload(HomeAutomation.Temperature.empty())
  }
}

@datatype class Temperature_Payload(value: HomeAutomation.Temperature) extends art.DataContent
