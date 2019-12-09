// #Sireum

package HA

import org.sireum._
import art._
import art.PortMode._
import art.DispatchPropertyProtocol._

// This file was auto-generated.  Do not edit

object Arch {
  val HA_impl_Instance_humid_sensor_update : HA.HomeAutomation.HumidSensor_Step_impl_Bridge = HA.HomeAutomation.HumidSensor_Step_impl_Bridge(
    id = 0,
    name = "HA_impl_Instance_humid_sensor_update",
    dispatchProtocol = Periodic(period = 1000),

    Humid_out = Port[HomeAutomation.Humidity] (id = 0, name = "HA_impl_Instance_humid_sensor_update_Humid_out", mode = EventOut),
    Humid_in = Port[HomeAutomation.Humidity] (id = 1, name = "HA_impl_Instance_humid_sensor_update_Humid_in", mode = EventIn)
  )
  val HA_impl_Instance_temp_sensor_update : HA.HomeAutomation.TemperatureSensor_Step_impl_Bridge = HA.HomeAutomation.TemperatureSensor_Step_impl_Bridge(
    id = 1,
    name = "HA_impl_Instance_temp_sensor_update",
    dispatchProtocol = Periodic(period = 1000),

    Temp_in = Port[HomeAutomation.Temperature] (id = 2, name = "HA_impl_Instance_temp_sensor_update_Temp_in", mode = EventIn),
    Temp_out = Port[HomeAutomation.Temperature] (id = 3, name = "HA_impl_Instance_temp_sensor_update_Temp_out", mode = EventIn)
  )
  val HA_impl_Instance_window_update : HA.HomeAutomation.Window_Step_impl_Bridge = HA.HomeAutomation.Window_Step_impl_Bridge(
    id = 2,
    name = "HA_impl_Instance_window_update",
    dispatchProtocol = Sporadic(min = 1),

    windowCmd = Port[HomeAutomation.WinCmd.Type] (id = 4, name = "HA_impl_Instance_window_update_windowCmd", mode = EventIn),
    windowAct = Port[art.Empty] (id = 5, name = "HA_impl_Instance_window_update_windowAct", mode = EventOut)
  )
  val HA_impl_Instance_termostat_update : HA.HomeAutomation.Thermostat_Step_impl_Bridge = HA.HomeAutomation.Thermostat_Step_impl_Bridge(
    id = 3,
    name = "HA_impl_Instance_termostat_update",
    dispatchProtocol = Sporadic(min = 1),

    TermostatCmd = Port[HomeAutomation.TermostatCMD.Type] (id = 6, name = "HA_impl_Instance_termostat_update_TermostatCmd", mode = EventIn),
    TermostatAct = Port[art.Empty] (id = 7, name = "HA_impl_Instance_termostat_update_TermostatAct", mode = EventOut)
  )
  val HA_impl_Instance_HA_control_algorithm : HA.HomeAutomation.algorithm_ex_Bridge = HA.HomeAutomation.algorithm_ex_Bridge(
    id = 4,
    name = "HA_impl_Instance_HA_control_algorithm",
    dispatchProtocol = Periodic(period = 1000),

    windowCMD = Port[HomeAutomation.WinCmd.Type] (id = 8, name = "HA_impl_Instance_HA_control_algorithm_windowCMD", mode = DataOut),
    termostatCDM = Port[HomeAutomation.TermostatCMD.Type] (id = 9, name = "HA_impl_Instance_HA_control_algorithm_termostatCDM", mode = DataIn),
    Temp = Port[HomeAutomation.Temperature] (id = 10, name = "HA_impl_Instance_HA_control_algorithm_Temp", mode = EventIn),
    Humid = Port[HomeAutomation.Humidity] (id = 11, name = "HA_impl_Instance_HA_control_algorithm_Humid", mode = EventIn)
  )
  val HA_impl_Instance_envir_algorithm : HA.HomeAutomation.Environment_impl_Bridge = HA.HomeAutomation.Environment_impl_Bridge(
    id = 5,
    name = "HA_impl_Instance_envir_algorithm",
    dispatchProtocol = Sporadic(min = 1),

  )

  val ad : ArchitectureDescription = {

    ArchitectureDescription(
      components = MSZ (HA_impl_Instance_humid_sensor_update, HA_impl_Instance_temp_sensor_update, HA_impl_Instance_window_update, HA_impl_Instance_termostat_update, HA_impl_Instance_HA_control_algorithm, HA_impl_Instance_envir_algorithm),

      connections = ISZ ()
    )
  }
}