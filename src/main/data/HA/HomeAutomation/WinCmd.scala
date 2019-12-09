// #Sireum

package HA.HomeAutomation

import org.sireum._
import HA._

// This file was auto-generated.  Do not edit

@enum object WinCmd {
  'OPEN
  'CLOSE
}

object WinCmd_Payload {
  def empty(): WinCmd_Payload = {
    return WinCmd_Payload(HomeAutomation.WinCmd.byOrdinal(0).get)
  }
}

@datatype class WinCmd_Payload(value: HomeAutomation.WinCmd.Type) extends art.DataContent
