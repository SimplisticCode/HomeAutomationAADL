// #Sireum

package HA.HomeAutomation

import org.sireum._
import HA._

// This file was auto-generated.  Do not edit

@msig trait Thermostat_Step_impl {

  def api : Thermostat_Step_impl_Bridge.Api

  def handleTermostatCmd(value : HomeAutomation.TermostatCMD.Type): Unit = {
    api.logInfo(s"received ${value}")
    api.logInfo("default handleTermostatCmd implementation")
  }

  def activate(): Unit = {}

  def deactivate(): Unit = {}

  def finalise(): Unit = {}

  def initialise(): Unit = {}

  def recover(): Unit = {}
}