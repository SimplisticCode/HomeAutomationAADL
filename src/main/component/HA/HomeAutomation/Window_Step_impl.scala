// #Sireum

package HA.HomeAutomation

import org.sireum._
import HA._

// This file was auto-generated.  Do not edit

@msig trait Window_Step_impl {

  def api : Window_Step_impl_Bridge.Api

  def handlewindowCmd(value : HomeAutomation.WinCmd.Type): Unit = {
    api.logInfo(s"received ${value}")
    api.logInfo("default handlewindowCmd implementation")
  }

  def activate(): Unit = {}

  def deactivate(): Unit = {}

  def finalise(): Unit = {}

  def initialise(): Unit = {}

  def recover(): Unit = {}
}