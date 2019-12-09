// #Sireum

package HA.HomeAutomation

import org.sireum._
import HA._

object Humidity {
  def empty(): HomeAutomation.Humidity = {
    return HomeAutomation.Humidity()
  }
}

@datatype class Humidity() // type skeleton

object Humidity_Payload {
  def empty(): Humidity_Payload = {
    return Humidity_Payload(HomeAutomation.Humidity.empty())
  }
}

@datatype class Humidity_Payload(value: HomeAutomation.Humidity) extends art.DataContent
