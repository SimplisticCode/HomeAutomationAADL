// #Sireum

package HA.HomeAutomation

import org.sireum._
import HA._

// This file was auto-generated.  Do not edit

@enum object TermostatCMD {
  'INC
  'DEC
}

object TermostatCMD_Payload {
  def empty(): TermostatCMD_Payload = {
    return TermostatCMD_Payload(HomeAutomation.TermostatCMD.byOrdinal(0).get)
  }
}

@datatype class TermostatCMD_Payload(value: HomeAutomation.TermostatCMD.Type) extends art.DataContent
